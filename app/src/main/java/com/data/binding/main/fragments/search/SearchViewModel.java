package com.data.binding.main.fragments.search;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.data.binding.domain.entities.CityWeather;
import com.data.binding.domain.model.SearchWeatherInteractor;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * ViewModel layer for search feature.
 */

public class SearchViewModel extends BaseObservable {

    private static final String TAG = "SEARCH-VIEW-MODEL";

    public final ObservableField<String> name = new ObservableField<>();

    @NonNull
    private SearchWeatherInteractor searchWeatherInteractor;

    public SearchViewModel(@NonNull SearchWeatherInteractor searchWeatherInteractor) {
        this.searchWeatherInteractor = searchWeatherInteractor;
    }

    public Observable<CityWeather> search(Observable<CharSequence> searchObservable) {
        return searchObservable
                .debounce(300, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(String::trim)
                .filter(searchTerm -> searchTerm.length() > 2)
                .flatMap(searchTerm -> searchWeatherInteractor.getSearchWeatherByCityName(searchTerm));
    }

}
