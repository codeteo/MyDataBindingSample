package com.data.binding.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.data.binding.databinding.ItemCityWeatherBinding;
import com.data.binding.domain.entities.CityWeather;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Adapter class to display {@link com.data.binding.domain.entities.CityWeather} items.
 */

public class CityWeatherAdapter extends RecyclerView.Adapter<CityWeatherAdapter.CityWeatherViewHolder> {

    private List<CityWeather> dataset;

    public CityWeatherAdapter() {
        this.dataset = new ArrayList<>();
    }

    @Override
    public CityWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCityWeatherBinding binding = ItemCityWeatherBinding.inflate(inflater, parent, false);
        return new CityWeatherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CityWeatherViewHolder holder, int position) {
        CityWeather cityWeather = dataset.get(position);
        holder.bind(cityWeather);
    }

    @Override
    public int getItemCount() {
        return dataset.size() == 0 ? 0 : dataset.size();
    }

    public void updateDataset(CityWeather cityWeather) {
        Timber.i("MESA STO UPDATE DATASET size == " + dataset.size());
        dataset.add(cityWeather);
        notifyDataSetChanged();
    }

    public class CityWeatherViewHolder extends RecyclerView.ViewHolder {
        private final ItemCityWeatherBinding binding;

        public CityWeatherViewHolder(ItemCityWeatherBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        public void bind(CityWeather cityWeather) {
            binding.setCityWeather(cityWeather);
            binding.executePendingBindings();
        }
    }

}
