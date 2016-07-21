package com.example.dreamfire.weather.view.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.base.BaseFragment;
import com.example.dreamfire.weather.realm.RealmController;
import com.example.dreamfire.weather.models.Current;
import com.example.dreamfire.weather.presenters.CurrentPresenterImpl;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.view.viewInterface.ICurrentView;

import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class CurrentFragment extends BaseFragment implements ICurrentView{
    private static final String TAG = "CurrentFragment";

    private ImageView mIvIcon;
    private TextView mTvCity, mTvTemp, mTvWeather, mTvLastUpdate;

    @Inject
    CurrentPresenterImpl mPresenter;

    private RealmController rc;
    private String mQuery;

    public interface onSomeEventListener{
       public void someEvent(String s);
    }

    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CurrentPresenterImpl();
        App.getComponent().inject(this);
        mPresenter.onCreate(this);
        if(savedInstanceState!= null && savedInstanceState.containsKey("qwery")) {
            mQuery = savedInstanceState.getString("qwery");
            mPresenter.loadCurrentWeather(savedInstanceState.getString("qwery"));
        }
        rc = RealmController.with(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_current, container, false);
        mPresenter.onCreateView(savedInstanceState);
        findUI(v);
        return v;
    }

    private void findUI(View v){
        mIvIcon = (ImageView) v.findViewById(R.id.ivIcon);
        mTvCity = (TextView) v.findViewById(R.id.tvCity);
        mTvTemp = (TextView) v.findViewById(R.id.tvTemp);
        mTvWeather = (TextView) v.findViewById(R.id.tvWeather);
        mTvLastUpdate = (TextView) v.findViewById(R.id.tvLastUpdate);
    }

    private void updateUI(Current current){
        if(current != null && mTvCity != null) {
            mTvCity.setText("City " + current.getName());
            mTvTemp.setText(current.getMain().getTemp() + " C");
            mTvWeather.setText(current.getWeather().get(0).getDescription());
            mTvLastUpdate.setText("Last update: " + current.getTimestamp());
            someEventListener.someEvent("Test interface");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void showCurrentWeather(Current current) {
        updateUI(current);
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
