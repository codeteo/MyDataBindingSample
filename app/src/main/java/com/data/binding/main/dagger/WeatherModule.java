package com.data.binding.main.dagger;

import com.data.binding.data.OpenWeatherMapApi;
import com.data.binding.domain.model.WeatherInteractor;
import com.data.binding.domain.model.WeatherInteractorImpl;
import com.data.binding.utils.MainActivityScope;
import com.data.binding.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger Module for {@link WeatherInteractor}
 */
@Module
public class WeatherModule {

    public WeatherModule() {

    }

    @MainActivityScope
    @Provides
    OpenWeatherMapApi providesOpenWeatherMapApi(Retrofit retrofit) {
        return retrofit.create(OpenWeatherMapApi.class);
    }

    @MainActivityScope
    @Provides
    WeatherInteractor providesWeatherInteractor(BaseSchedulerProvider baseScheduler, OpenWeatherMapApi openWeatherMapApi) {
        return new WeatherInteractorImpl(baseScheduler, openWeatherMapApi);
    }

}