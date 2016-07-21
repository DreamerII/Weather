package com.example.dreamfire.weather.database;

import com.example.dreamfire.weather.models.Current;

import rx.Observable;

/**
 * Created by dreamfire on 14.07.16.
 */
public interface ApiDB {
    Observable<Current> getCurrentDB(String location);
}
