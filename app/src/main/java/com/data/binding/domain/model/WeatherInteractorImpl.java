package com.data.binding.domain.model;

import android.support.annotation.NonNull;

import com.data.binding.domain.entities.CityWeather;
import com.data.binding.utils.schedulers.BaseSchedulerProvider;

import rx.Observable;

/**
 * This class is an implementation of {@link WeatherInteractor} that represents a use case for
 * retrieving a collection of all {@link }. // TODO: 6/9/17 add data entity here
 */

public class WeatherInteractorImpl implements WeatherInteractor {

    @NonNull
    private BaseSchedulerProvider schedulerProvider;

    public WeatherInteractorImpl(@NonNull BaseSchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Observable<CityWeather> getWeatherByCityName(String name) {
        return null;
    }

    @Override
    public Observable<CityWeather> getWeatherByCityId(long id) {
        return null;
    }
}
