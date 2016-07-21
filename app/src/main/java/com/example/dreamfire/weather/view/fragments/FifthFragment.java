package com.example.dreamfire.weather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.base.BaseFragment;
import com.example.dreamfire.weather.models.Fifth;
import com.example.dreamfire.weather.presenters.FifthPresenterImpl;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.view.viewInterface.IFifthView;

import javax.inject.Inject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class FifthFragment extends BaseFragment implements IFifthView {
    private static final String TAG = "FifthFragment";

    @Inject
    FifthPresenterImpl mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPresenter = new FifthPresenterImpl(this);
        App.getComponent().inject(this);
        mPresenter.onCreate(this);
//        mPresenter.loadFifthWeather("Kiev");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fifth, container, false);

        return v;
    }

    @Override
    public void showFifthWeather(Fifth fifth) {
        Log.d(TAG, "Fifth " + fifth.getList().size());
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, error);
    }


    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }
}
