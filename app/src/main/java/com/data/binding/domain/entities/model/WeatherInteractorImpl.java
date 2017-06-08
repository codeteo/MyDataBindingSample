package com.data.binding.domain.entities.model;

import android.support.annotation.NonNull;

import com.data.binding.utils.schedulers.BaseSchedulerProvider;

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

}
