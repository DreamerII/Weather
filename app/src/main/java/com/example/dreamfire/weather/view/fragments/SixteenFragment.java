package com.example.dreamfire.weather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dreamfire.weather.view.adapters.SixteenRvAdapter;
import com.example.dreamfire.weather.App;
import com.example.dreamfire.weather.base.BaseFragment;
import com.example.dreamfire.weather.models.Sixteen;
import com.example.dreamfire.weather.presenters.SixteenPresenterImpl;
import com.example.dreamfire.weather.presenters.base.BasePresenter;
import com.example.dreamfire.weather.R;
import com.example.dreamfire.weather.view.viewInterface.ISixteenView;

import javax.inject.Inject;

/**
 * Created by dreamfire on 10.06.16.
 */
public class SixteenFragment extends BaseFragment implements ISixteenView{
    private static final String TAG = "SixteenFragment";
    @Inject
    SixteenPresenterImpl mPresenter;
    private RecyclerView mRecycler;
    private TextView mTvCityName;
    private SixteenRvAdapter mAdapter;

    private Sixteen sixteen;
    private static SixteenFragment sFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
//        mPresenter = new SixteenPresenterImpl(this);
//        if()
//        mPresenter.loadWeather();
        mPresenter.onCreate(this);

        if(savedInstanceState != null && savedInstanceState.containsKey("qwery")) {
            mPresenter.loadWeather(savedInstanceState.getString("qwery"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sixteen, container, false);
            findUI(v);
        mPresenter.onCreateView(savedInstanceState);
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.savedInstanceState(outState);
    }

    private void findUI(View _v){
        mTvCityName = (TextView) _v.findViewById(R.id.tvCityName);
        mRecycler = (RecyclerView) _v.findViewById(R.id.sixRecucler);
        mRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(llm);
//        mAdapter = new SixteenRvAdapter(getActivity());
//        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void showWeather(Sixteen sixteen) {
        this.sixteen = sixteen;
        Log.d(TAG, sixteen.getList().size()+"");
        mTvCityName.setText(sixteen.getCity().getName());
//        mAdapter.update(sixteen.getList());
        mRecycler.setAdapter(new SixteenRvAdapter(sixteen.getList(), getActivity()));
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, error);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume " + (sixteen != null));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//
//        if(savedInstanceState != null && savedInstanceState.containsKey("qwery")) {
//            mPresenter.loadWeather(savedInstanceState.getString("qwery"));
//        }
//        Log.d(TAG, "onActivityCreated");
//        if(mAdapter != null && (sixteen != null))
//            mAdapter.update(sixteen.getList());
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }
}
