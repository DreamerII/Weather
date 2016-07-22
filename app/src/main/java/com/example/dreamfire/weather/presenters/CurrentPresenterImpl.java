package com.example.dreamfire.weather.presenters;

import android.os.Bundle;
import android.util.Log;

import com.example.dreamfire.weather.models.Current;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.realm.RealmController;
import com.example.dreamfire.weather.view.viewInterface.ICurrentView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by dreamfire on 10.06.16.
 */
public class CurrentPresenterImpl extends BasePresenter {
    private static final String TAG = "CurrentPresenterImpl";
    private static final String BUNDLE_CURRENT_KEY = "BUNDLE_CURRENT_KEY";
    private ICurrentView mView;
    private Current mCurrent;

    @Inject
    public CurrentPresenterImpl(){
    }

    public void onCreate(ICurrentView view){
        this.mView = view;
    }

    public void loadCurrentWeather(String location) {

       Subscription subscription = model.getCurrentWeather(location)
                .subscribe(new Observer<Current>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onErrors  " + e.getMessage());
                        mView.showError(e.getMessage());
                        loadCurrentWeatherFromDB(location);
                    }

                    @Override
                    public void onNext(Current current) {
                        Log.d(TAG, "onNext");
                        if(current != null) {
                            RealmController.getInstance().saveCurrent(current);
                            mCurrent = current;
                            mView.showCurrentWeather(mCurrent);
                        }
                    }
                });
        addSubscription(subscription);
    }

    public void loadCurrentWeatherFromDB(String location){
        Subscription subscription = model.getCurrentDB(location)
                .subscribe(new Observer<Current>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted DB");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError DB");
                    }

                    @Override
                    public void onNext(Current current) {
                        Log.d(TAG, "onNext DB");
                        if(current != null) {
                            mCurrent = current;
                            mView.showCurrentWeather(mCurrent);
                        }
                    }
                });
    }

    public void loadCurrentCoord(double lat, double lon){
        Subscription subscription = model.getCurrentCoord(lat, lon)
                .subscribe(current -> {
                    if(current != null){
                        Log.d(TAG, "OK coord");
                        mCurrent = current;
                        mView.showCurrentWeather(mCurrent);
                    }
                },
                        throwable -> {Log.d(TAG, "Error coord");});
    }

    public void onCreateView(Bundle savedInstanceState) {
        if(savedInstanceState != null)
            mCurrent = (Current)savedInstanceState.getSerializable(BUNDLE_CURRENT_KEY);

        if(mCurrent != null)
            mView.showCurrentWeather(mCurrent);
    }

    public void onSaveInstanceState(Bundle outState){
        if(mCurrent != null)
            outState.putSerializable(BUNDLE_CURRENT_KEY, mCurrent);
    }
}
