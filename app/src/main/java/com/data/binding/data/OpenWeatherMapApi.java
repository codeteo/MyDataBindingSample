package com.data.binding.data;

import com.data.binding.domain.entities.CityWeather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Retrofit's Interface to fetch {@link CityWeather} data from network.
 */

public interface OpenWeatherMapApi {

    @GET("weather")
    public Observable<CityWeather> getWeatherByCityName(@Query("q") String cityName, @Query("appid") String appId);

    @GET("weather")
    public Observable<CityWeather> getWeatherByCityId(@Query("id") long cityId, @Query("appid") String appId);
}