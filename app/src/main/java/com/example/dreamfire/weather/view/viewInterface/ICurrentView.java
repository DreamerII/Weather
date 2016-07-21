package com.example.dreamfire.weather.view.viewInterface;

import com.example.dreamfire.weather.models.Current;

/**
 * Created by dreamfire on 10.06.16.
 */
public interface ICurrentView {
    void showCurrentWeather(Current current);
    void showError(String error);
}
