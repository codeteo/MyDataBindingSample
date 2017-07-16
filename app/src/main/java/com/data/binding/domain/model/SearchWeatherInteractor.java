package com.data.binding.domain.model;

import com.data.binding.domain.entities.CityWeather;

import rx.Observable;

/**
 * Interactor for Search Feature.
 */

public interface SearchWeatherInteractor {

    Observable<CityWeather> getSearchWeatherByCityName(String name);

}
