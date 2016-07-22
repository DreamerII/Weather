package com.example.dreamfire.weather.view.fragments;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.base.BaseFragment;
import com.example.dreamfire.weather.databinding.FragmentCurrentBinding;
import com.example.dreamfire.weather.realm.RealmController;
import com.example.dreamfire.weather.models.Current;
import com.example.dreamfire.weather.presenters.CurrentPresenterImpl;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.view.viewInterface.ICurrentView;

import javax.inject.Inject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class CurrentFragment extends BaseFragment implements ICurrentView{
    private static final String TAG = "CurrentFragment";

    @Inject
    CurrentPresenterImpl mPresenter;

    private RealmController rc;
    private String mQuery;
    private FragmentCurrentBinding binding;

    public interface onSomeEventListener{
       void someEvent(String s);
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
        } else if(savedInstanceState != null && savedInstanceState.containsKey("location")){
            Location location = savedInstanceState.getParcelable("location");
            mPresenter.loadCurrentCoord(location.getLatitude(), location.getLongitude());
        }
        rc = RealmController.with(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current, container, false);
        View v = binding.getRoot();
        mPresenter.onCreateView(savedInstanceState);
        return v;
    }

    private void updateUI(Current current){
        if(current != null) {
            binding.tvCity.setText("City " + current.getName());
            binding.tvTemp.setText(current.getMain().getTemp() + " C");
            binding.tvTemp.setText(current.getWeather().get(0).getDescription());
            binding.tvLastUpdate.setText("Last update: " + current.getTimestamp());
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
