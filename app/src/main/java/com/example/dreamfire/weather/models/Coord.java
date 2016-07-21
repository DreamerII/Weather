package com.example.dreamfire.weather.models;


import io.realm.RealmObject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class Coord extends RealmObject {
    private int id;
    private float lon;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
