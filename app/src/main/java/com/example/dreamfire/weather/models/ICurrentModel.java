package com.example.dreamfire.weather.models;

import rx.Observable;

/**
 * Created by dreamfire on 10.06.16.
 */
public interface ICurrentModel {
    Observable<Current> getCurrentWeather(String location);
}
