package com.example.dreamfire.weather.models;

import io.realm.RealmObject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class Clouds extends RealmObject {
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
