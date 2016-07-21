package com.example.dreamfire.weather;

import android.app.Application;

import com.example.dreamfire.weather.realm.RealmController;
import com.example.dreamfire.weather.view.di.AppComponent;
import com.example.dreamfire.weather.view.di.DaggerAppComponent;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dreamfire on 10.06.16.
 */
public class App extends Application {
    private static AppComponent component;
    public static String name;

    public static AppComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(getApplicationContext())
                .deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfig);
        RealmController.with(this);
        component = buildComponent();
    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder().build();
    }
}
