package com.example.dreamfire.weather.database;

import android.content.Context;

import com.example.dreamfire.weather.models.Current;

import io.realm.RealmResults;

/**
 * Created by dreamfire on 14.07.16.
 */
public class RealmCurrentAdapter extends RealmModelAdapter<Current> {
    public RealmCurrentAdapter(Context c, RealmResults<Current> realmResults) {
        super(c, realmResults);
    }
}
