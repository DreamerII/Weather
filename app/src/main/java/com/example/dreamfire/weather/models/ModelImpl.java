package com.example.dreamfire.weather.models;

import com.example.dreamfire.weather.api.ApiConstant;
import com.example.dreamfire.weather.api.ApiWeather;
import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.realm.RealmController;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dreamfire on 16.06.16.
 */
public class ModelImpl implements Model {
    @Inject
    ApiWeather service;

    public ModelImpl(){
        App.getComponent().inject(this);
    }

    @Override
    public Observable<Current> getCurrentWeather(String location) {
        return service.getCurrentWeather(location, ApiConstant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Current> getCurrentDB(String location) {
        return RealmController.getInstance().getCurrent(location)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Fifth> getFifthListWeather(String location) {
        return service.getFifthListWeather(location, ApiConstant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Sixteen> getSixteenWather(String location) {
        return service.getSixteenWeather(location, 16, ApiConstant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
