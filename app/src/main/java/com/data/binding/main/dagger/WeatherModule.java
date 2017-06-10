package com.data.binding.main.dagger;

import com.data.binding.domain.model.WeatherInteractorImpl;
import com.data.binding.domain.model.WeatherInteractor;
import com.data.binding.utils.MainActivityScope;
import com.data.binding.utils.schedulers.BaseSchedulerProvider;
import com.data.binding.utils.schedulers.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for {@link WeatherInteractor}
 */
@Module
public class WeatherModule {

    public WeatherModule() {

    }

    @Provides
    BaseSchedulerProvider baseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    @MainActivityScope
    @Provides
    WeatherInteractor providesWeatherInteractor(BaseSchedulerProvider baseScheduler) {
        return new WeatherInteractorImpl(baseScheduler);
    }

}