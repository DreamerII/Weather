package com.example.dreamfire.weather.realm;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.dreamfire.weather.models.Clouds;
import com.example.dreamfire.weather.models.Coord;
import com.example.dreamfire.weather.models.Current;
import com.example.dreamfire.weather.models.Main;
import com.example.dreamfire.weather.models.Sys;
import com.example.dreamfire.weather.models.Weather;
import com.example.dreamfire.weather.models.Wind;

import io.realm.Realm;
import rx.Observable;

/**
 * Created by dreamfire on 13.07.16.
 */
public class RealmController {
    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application){
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment){
        if(instance == null){
            instance = new RealmController(fragment.getActivity().getApplication());
        }

        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public Observable<Current> getCurrent(String location){
        Current c = realm.where(Current.class).equalTo("name", location).findFirst();
        return Observable.just(c);
    }

    public void saveCurrent(Current current){
// Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

// Query Realm for all dogs younger than 2 years old
//        final RealmResults<Sys> puppies = realm.where(Sys.class).lessThan("id", 2).findAll();
//        puppies.size(); // => 0 because no dogs have been added to the Realm yet

// Persist your data in a transaction
        realm.beginTransaction();
        realm.deleteAll();
        final Sys sys = realm.copyToRealm(current.getSys());
        final Coord coord = realm.copyToRealm(current.getCoord());
        final Wind wind = realm.copyToRealm(current.getWind());
        final Clouds clouds = realm.copyToRealm(current.getClouds());
        final Main main = realm.copyToRealm(current.getMain());

        Current cur = realm.createObject(Current.class);
        cur.setCoord(coord);
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setBase(current.getBase());
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setMain(main);
        realm.commitTransaction();

        realm.beginTransaction();
        for (int q = 0; q < current.getWeather().size(); q++) {
            Weather w = realm.copyToRealm(current.getWeather().get(q));
            cur.getWeather().add(w);
        }
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setWind(wind);
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setClouds(clouds);
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setDt(current.getDt());
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setSys(sys);
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setId(current.getId());
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setName(current.getName());
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setCod(current.getCod());
        realm.commitTransaction();

        realm.beginTransaction();
        cur.setTimestamp(System.currentTimeMillis());
        realm.commitTransaction();
    }

}
