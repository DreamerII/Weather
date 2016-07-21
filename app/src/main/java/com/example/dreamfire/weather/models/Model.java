package com.example.dreamfire.weather.models;

import rx.Observable;

/**
 * Created by dreamfire on 16.06.16.
 */
public interface Model {
    Observable<Current> getCurrentWeather(String location);
    Observable<Current> getCurrentDB(String location);
    Observable<Fifth> getFifthListWeather(String location);
    Observable<Sixteen> getSixteenWather(String location);
}
