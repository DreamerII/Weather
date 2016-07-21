package com.example.dreamfire.weather.view.di;

import com.example.dreamfire.weather.presenters.CurrentPresenterImpl;
import com.example.dreamfire.weather.presenters.FifthPresenterImpl;
import com.example.dreamfire.weather.presenters.SixteenPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dreamfire on 16.06.16.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    CurrentPresenterImpl provideCurrentView(){
        return new CurrentPresenterImpl();
    }

    @Provides
    @Singleton
    FifthPresenterImpl provideFifthPresenter(){
        return new FifthPresenterImpl();
    }

    @Provides
    @Singleton
    SixteenPresenterImpl provideSixteenPresenter(){
        return new SixteenPresenterImpl();
    }
}
