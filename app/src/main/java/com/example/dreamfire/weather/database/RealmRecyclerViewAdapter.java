package com.example.dreamfire.weather.database;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by dreamfire on 14.07.16.
 */
public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    private RealmBaseAdapter<T> mAdapter;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public T getItem(int position){
        return mAdapter.getItem(position);
    }

    public RealmBaseAdapter<T> getRealmAdapter(){
        return mAdapter;
    }

    public void setRealmAdapter(RealmBaseAdapter<T> adapter){
        mAdapter = adapter;
    }
}
