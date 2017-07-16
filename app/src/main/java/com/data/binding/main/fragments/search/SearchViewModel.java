package com.data.binding.main.fragments.search;

import android.support.annotation.NonNull;

import com.data.binding.domain.model.SearchWeatherInteractor;

import rx.Observable;

/**
 * ViewModel layer for search feature.
 */

public class SearchViewModel {

    private static final String TAG = "SEARCH-VIEW-MODEL";
    
    @NonNull
    private SearchWeatherInteractor searchWeatherInteractor;

    public SearchViewModel(@NonNull SearchWeatherInteractor searchWeatherInteractor) {
        this.searchWeatherInteractor = searchWeatherInteractor;
    }

    public void search(Observable<CharSequence> searchObservable) {


    }

}
