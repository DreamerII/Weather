package com.example.dreamfire.weather.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by dreamfire on 13.07.16.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, foreignKeysSupported = true)
public class AppDatabase {

    public static final String NAME = "App";

    public static final int VERSION = 4;
}
