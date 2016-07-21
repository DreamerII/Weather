package com.example.dreamfire.weather.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.presenters.base.BasePresenter;

/**
 * Created by dreamfire on 16.06.16.
 */
public abstract class BaseFragment extends Fragment {
    protected abstract BasePresenter getPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(getPresenter() != null)
            getPresenter().onStop();
    }
}
