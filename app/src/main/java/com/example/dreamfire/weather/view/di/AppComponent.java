package com.example.dreamfire.weather.view.di;

import android.util.Log;

import com.example.dreamfire.weather.models.CurrentModelImpl;
import com.example.dreamfire.weather.models.FifthModelImpl;
import com.example.dreamfire.weather.models.ModelImpl;
import com.example.dreamfire.weather.models.SixteenModelImpl;
import com.example.dreamfire.weather.base.BaseFragment;
import com.example.dreamfire.weather.view.fragments.CurrentFragment;
import com.example.dreamfire.weather.view.fragments.FifthFragment;
import com.example.dreamfire.weather.view.fragments.SixteenFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dreamfire on 16.06.16.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(CurrentFragment fragment);
    void inject(FifthFragment fragment);
    void inject(SixteenFragment fragment);
    void inject(CurrentModelImpl model);
    void inject(FifthModelImpl model);
    void inject(SixteenModelImpl model);

    void inject(ModelImpl model);
    void inject(BaseFragment fragment);
}
