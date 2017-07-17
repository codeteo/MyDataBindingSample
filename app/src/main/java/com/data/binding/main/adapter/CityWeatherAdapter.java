package com.data.binding.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Adapter class to display {@link com.data.binding.domain.entities.CityWeather} items.
 */

public class CityWeatherAdapter extends RecyclerView.Adapter {

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

    public class CityWeatherViewHolder extends RecyclerView.ViewHolder {

        public CityWeatherViewHolder(View itemView) {
            super(itemView);
        }
    }

}
