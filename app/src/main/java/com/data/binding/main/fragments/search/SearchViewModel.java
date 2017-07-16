package com.data.binding.main.fragments.search;

import android.support.annotation.NonNull;

import com.data.binding.domain.model.SearchWeatherInteractor;

/**
 * ViewModel layer for search feature.
 */

public class SearchViewModel {

    @NonNull
    private SearchWeatherInteractor searchWeatherInteractor;

    public SearchViewModel(@NonNull SearchWeatherInteractor searchWeatherInteractor) {
        this.searchWeatherInteractor = searchWeatherInteractor;
    }


}
