package com.data.binding.main.fragments.search;

import android.view.View;
import android.widget.Toast;

import com.data.binding.domain.entities.CityWeather;

/**
 * Created by css on 8/3/17.
 */

public class SearchPresenter {

    public void onFavoriteClick(View view, CityWeather cityWeather) {
        Toast.makeText(view.getContext(), cityWeather.getName(), Toast.LENGTH_SHORT).show();
    }

}
