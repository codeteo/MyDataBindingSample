package com.data.binding.main.fragments.search;

import android.support.annotation.NonNull;
import android.util.Log;

import com.data.binding.domain.model.SearchWeatherInteractor;

import java.util.concurrent.TimeUnit;

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

        searchObservable
                .debounce(300, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(String::trim)
                .filter(searchTerm -> searchTerm.length() > 2)
                .flatMap(searchTerm -> searchWeatherInteractor.getSearchWeatherByCityName(searchTerm))
                .subscribe(cityWeather -> {
                    Log.i(TAG, "search name == " + cityWeather.getName());
                }, throwable -> Log.i(TAG, "search onError == " + throwable.getMessage()));


    }

}
