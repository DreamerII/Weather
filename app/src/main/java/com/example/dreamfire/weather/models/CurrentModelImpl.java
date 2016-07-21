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
public class CurrentModelImpl implements ICurrentModel {
    @Inject
    ApiWeather service;

    public CurrentModelImpl(){
        App.getComponent().inject(this);
    }

    @Override
    public Observable<Current> getCurrentWeather(String location) {
        return service.getCurrentWeather(location, ApiConstant.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
