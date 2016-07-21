package com.example.dreamfire.weather.presenters;

import android.util.Log;

import com.example.dreamfire.weather.models.Fifth;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.view.viewInterface.IFifthView;

import rx.Observer;
import rx.Subscription;

/**
 * Created by dreamfire on 10.06.16.
 */
public class FifthPresenterImpl extends BasePresenter {
    private static final String TAG = "FifthPresenterImpl";
//    private IFifthModel mFifthModel = new FifthModelImpl();
    private IFifthView mView;

//    private Subscription subscription = Subscriptions.empty();

//    public FifthPresenterImpl(IFifthView view){
//        mView = view;
//    }

    public void onCreate(IFifthView view){
        mView = view;
    }

    public void loadFifthWeather(String location) {
//        if(!subscription.isUnsubscribed())
//            subscription.unsubscribe();

        Subscription subscription = model.getFifthListWeather(location)
                .subscribe(new Observer<Fifth>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError");
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Fifth fifth) {
                        Log.d(TAG, "onNext");
                        if(fifth != null)
                            mView.showFifthWeather(fifth);
                    }
                });

        addSubscription(subscription);
    }
}
