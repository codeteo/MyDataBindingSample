package com.data.binding.main;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.data.binding.domain.entities.User;
import com.data.binding.domain.model.WeatherInteractor;

import javax.inject.Inject;

/**
 * ViewModel layer between View and Model. Binds to the View and reacts to events.
 */

public class ViewModel implements GetUserCallback {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();

    @NonNull
    private MainModel model;

    @NonNull
    private WeatherInteractor weatherInteractor;

    @Inject
    public ViewModel(@NonNull MainModel model, @NonNull WeatherInteractor weatherInteractor) {
        this.model = model;
        this.weatherInteractor = weatherInteractor;
    }

    public void start(String userId) {
        // some over-engineering magic with the model
        model.getUser(userId, this);
        weatherInteractor.getWeatherByCityName("Thessaloniki");
    }

    @Override
    public void onUserLoaded(User user) {
        name.set(user.getName());
        city.set(user.getCity());
        age.set(user.getAge());
    }

    @Override
    public void onUserNotAvailable() {
        // notify user
    }
}
