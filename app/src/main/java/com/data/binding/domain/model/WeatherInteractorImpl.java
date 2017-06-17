package com.data.binding.domain.model;

import android.support.annotation.NonNull;

import com.data.binding.BuildConfig;
import com.data.binding.data.OpenWeatherMapApi;
import com.data.binding.domain.entities.CityWeather;
import com.data.binding.utils.schedulers.BaseSchedulerProvider;

import rx.Observable;

/**
 * This class is an implementation of {@link WeatherInteractor} that represents a use case for
 * retrieving a collection of all {@link CityWeather}
 */

public class WeatherInteractorImpl implements WeatherInteractor {

    private final String apiKey = BuildConfig.API_KEY;

    @NonNull
    private BaseSchedulerProvider schedulerProvider;

    @NonNull
    private OpenWeatherMapApi openWeatherMapApi;

    public WeatherInteractorImpl(@NonNull BaseSchedulerProvider schedulerProvider, @NonNull OpenWeatherMapApi openWeatherMapApi) {
        this.schedulerProvider = schedulerProvider;
        this.openWeatherMapApi = openWeatherMapApi;
    }

    @Override
    public Observable<CityWeather> getWeatherByCityName(String name) {
        return openWeatherMapApi
                .getWeatherByCityName(name, apiKey)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @Override
    public Observable<CityWeather> getWeatherByCityId(long id) {
        return openWeatherMapApi
                .getWeatherByCityId(id, apiKey)
                .subscribeOn(schedulerProvider.io());
    }
}
