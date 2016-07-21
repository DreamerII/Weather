package com.example.dreamfire.weather.models;

import com.example.dreamfire.weather.api.ApiConstant;
import com.example.dreamfire.weather.api.ApiWeather;
import com.example.dreamfire.weather.App;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dreamfire on 10.06.16.
 */
public class FifthModelImpl implements IFifthModel {
    @Inject
    ApiWeather service;

    public FifthModelImpl(){
        App.getComponent().inject(this);
    }

    @Override
    public Observable<Fifth> getFifthListWeather(String location) {
        return service.getFifthListWeather(location, ApiConstant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
