package com.example.dreamfire.weather.presenters.base;

import com.example.dreamfire.weather.models.Model;
import com.example.dreamfire.weather.models.ModelImpl;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dreamfire on 16.06.16.
 */
public class BasePresenter implements Presenter {
    private CompositeSubscription compositeSubscription = new CompositeSubscription();
    protected Model model = new ModelImpl();

    protected void addSubscription(Subscription s){
        compositeSubscription.add(s);
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }
}
