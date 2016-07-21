package com.example.dreamfire.weather.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by dreamfire on 13.07.16.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    public static final String NAME = "MyDataBase";

    public static final int VERSION = 11;
}
