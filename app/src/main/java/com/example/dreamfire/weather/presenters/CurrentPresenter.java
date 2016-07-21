package com.example.dreamfire.weather.presenters;

/**
 * Created by dreamfire on 10.06.16.
 */
public interface CurrentPresenter {
    void loadCurrentWeather(String location);
    void onStop();
}
