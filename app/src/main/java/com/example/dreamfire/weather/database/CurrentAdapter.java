package com.example.dreamfire.weather.database;

import android.content.Context;

import com.example.dreamfire.weather.models.Current;

/**
 * Created by dreamfire on 14.07.16.
 */
public class CurrentAdapter extends RealmRecyclerViewAdapter<Current> {
    private Context context;

    public CurrentAdapter(Context context){
        this.context = context;
    }
}
