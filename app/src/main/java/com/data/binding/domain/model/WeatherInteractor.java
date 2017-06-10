package com.data.binding.domain.model;

import com.data.binding.domain.entities.CityWeather;

import rx.Observable;

/**
 * Created by css on 6/8/17.
 */

public interface WeatherInteractor {

    Observable<CityWeather> getWeatherByCityName(String name);

    Observable<CityWeather> getWeatherByCityId(long id);

}
