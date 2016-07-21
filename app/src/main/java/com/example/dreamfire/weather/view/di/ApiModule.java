package com.example.dreamfire.weather.view.di;

import com.example.dreamfire.weather.api.ApiFactory;
import com.example.dreamfire.weather.api.ApiWeather;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dreamfire on 16.06.16.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    ApiWeather provideApiWeather(){
        return ApiFactory.getRetrofitAdapter();
    }
}
