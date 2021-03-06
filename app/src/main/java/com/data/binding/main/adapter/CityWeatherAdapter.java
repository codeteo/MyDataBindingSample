package com.data.binding.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.data.binding.databinding.ItemCityWeatherBinding;
import com.data.binding.domain.entities.CityWeather;
import com.data.binding.main.fragments.search.SearchPresenter;

import java.util.ArrayList;
import java.util.List;

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
        if (!dataset.contains(cityWeather)) {
            dataset.add(cityWeather);
            notifyDataSetChanged();
        }
    }

    public class CityWeatherViewHolder extends RecyclerView.ViewHolder {
        private final ItemCityWeatherBinding binding;

        public CityWeatherViewHolder(ItemCityWeatherBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        public void bind(CityWeather cityWeather) {
            binding.setCityWeather(cityWeather);
            binding.setPresenter(new SearchPresenter());
            binding.executePendingBindings();
        }
    }

}
