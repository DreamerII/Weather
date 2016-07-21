package com.example.dreamfire.weather.api;

import com.example.dreamfire.weather.models.Current;
import com.example.dreamfire.weather.models.Fifth;
import com.example.dreamfire.weather.models.Sixteen;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dreamfire on 10.06.16.
 */
public interface ApiWeather {
//    appid

    @GET("weather")
    Observable<Current> getCurrentWeather(@Query("q") String name,
                                          @Query("appid") String appid);

    @GET("forecast")
    Observable<Fifth> getFifthListWeather(@Query("q") String name,
                                          @Query("appid") String appid);

    @GET("forecast/daily")
    Observable<Sixteen> getSixteenWeather(@Query("q") String name,
                                          @Query("cnt") int cnt,
                                          @Query("appid") String appid);

}
