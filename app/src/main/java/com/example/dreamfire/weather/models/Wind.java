package com.example.dreamfire.weather.models;

import io.realm.RealmObject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class Wind extends RealmObject {
    private float speed;
    private float deg;
    private float gust;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public float getGust() {
        return gust;
    }

    public void setGust(float gust) {
        this.gust = gust;
    }
}
