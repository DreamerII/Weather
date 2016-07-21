package com.example.dreamfire.weather.models;

import com.example.dreamfire.weather.api.ApiConstant;
import com.example.dreamfire.weather.api.ApiWeather;
import com.example.dreamfire.weather.App;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dreamfire on 11.06.16.
 */
public class SixteenModelImpl implements ISixteenModel {
    @Inject
    ApiWeather service;

    public SixteenModelImpl(){
        App.getComponent().inject(this);
    }

    @Override
    public Observable<Sixteen> getSixteenWather(String location) {
        return service.getSixteenWeather(location, 16, ApiConstant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
