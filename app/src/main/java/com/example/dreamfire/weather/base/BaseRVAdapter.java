package com.example.dreamfire.weather.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dreamfire.weather.R;

import java.util.List;

/**
 * Created by dreamfire on 16.06.16.
 */
public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter<BaseRVAdapter.ViewHolder>{
    private List<T> list;

    public BaseRVAdapter(List<T> list){
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<T> getList(){
        return list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sixteen_item, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIcon;
        public TextView tvDate;
        public TextView tvMain;
        public TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.ivIcon);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvMain = (TextView) itemView.findViewById(R.id.tvWeather);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
