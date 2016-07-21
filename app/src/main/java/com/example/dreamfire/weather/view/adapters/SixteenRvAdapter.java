package com.example.dreamfire.weather.view.adapters;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.dreamfire.weather.base.BaseRVAdapter;
import com.example.dreamfire.weather.models.SixteenItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dreamfire on 11.06.16.
 */
public class SixteenRvAdapter extends BaseRVAdapter<SixteenItem> {
    private List<SixteenItem> mItemList = new ArrayList<>();
    private Context context;

    public SixteenRvAdapter(List<SixteenItem> list, Context c) {
        super(list);
        context = c;
    }

    public void update(List<SixteenItem> items){
        mItemList = items;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BaseRVAdapter.ViewHolder holder, int position) {
        Glide.with(context).load("http://openweathermap.org/img/w/"+getList().get(position).getWeather().get(0).getIcon()+".png")
                .into(holder.mIcon);
//        new Date()
        holder.tvDate.setText(new Date(getList().get(position).getDt()).toString());
        holder.tvMain.setText(getList().get(position).getWeather().get(0).getMain());
        holder.tvDesc.setText(getList().get(position).getWeather().get(0).getDescription());
    }
}
