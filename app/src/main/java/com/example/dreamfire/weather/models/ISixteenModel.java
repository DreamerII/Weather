package com.example.dreamfire.weather.models;

import rx.Observable;

/**
 * Created by dreamfire on 11.06.16.
 */
public interface ISixteenModel {
    Observable<Sixteen> getSixteenWather(String location);
}
