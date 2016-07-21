package com.example.dreamfire.weather.presenters;

import android.os.Bundle;
import android.util.Log;

import com.example.dreamfire.weather.models.Sixteen;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.view.viewInterface.ISixteenView;

import rx.Observer;
import rx.Subscription;

/**
 * Created by dreamfire on 11.06.16.
 */
public class SixteenPresenterImpl extends BasePresenter {
    public static final String TAG = "SixteenPresenterImpl";
    private static final String BUNDLE_SIXTEEN_KEY = "BUNDLE_SIXTEEN_KEY";
//    private ISixteenModel mSixteenModel = new SixteenModelImpl();
    private ISixteenView mSixteenView;
    private Sixteen mSixteen;

//    private Subscription subscription = Subscriptions.empty();

//    public SixteenPresenterImpl(ISixteenView view){
//        mSixteenView = view;
//    }

    public void onCreate(ISixteenView view) {
        mSixteenView = view;
    }

    public void loadWeather(String location) {

//        if(!subscription.isUnsubscribed())
//            subscription.unsubscribe();

        Subscription subscription = model.getSixteenWather(location)
                .subscribe(new Observer<Sixteen>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                        mSixteenView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Sixteen sixteen) {
                        Log.d(TAG, "onNext");
                        if(sixteen != null) {
                            mSixteen = sixteen;
                            mSixteenView.showWeather(mSixteen);
                        }
                    }
                });

        addSubscription(subscription);
    }

    public void onCreateView(Bundle savedInstanceState){
        if(savedInstanceState != null){
            mSixteen = (Sixteen)savedInstanceState.getSerializable(BUNDLE_SIXTEEN_KEY);
        }

        if(mSixteen != null)
            mSixteenView.showWeather(mSixteen);
    }

    public void savedInstanceState(Bundle outState){
        if(mSixteen != null){
            outState.putSerializable(BUNDLE_SIXTEEN_KEY, mSixteen);
        }
    }
}
