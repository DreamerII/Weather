package com.example.dreamfire.weather.models;

import rx.Observable;

/**
 * Created by dreamfire on 10.06.16.
 */
public interface IFifthModel {
    Observable<Fifth> getFifthListWeather(String location);
}
