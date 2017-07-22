package com.data.binding.main.fragments.main;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.data.binding.domain.model.WeatherInteractor;

import javax.inject.Inject;

import rx.Subscription;

/**
 * ViewModel layer between View and Model. Binds to the View and reacts to events.
 */

public class MainViewModel  {

    private static final String TAG = "VIEW-MODEL";

    private Subscription subscription;

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> icon = new ObservableField<>();

    @NonNull
    private WeatherInteractor weatherInteractor;

    @Inject
    public MainViewModel(@NonNull WeatherInteractor weatherInteractor) {
        this.weatherInteractor = weatherInteractor;
    }

    public void start() {
        subscription = weatherInteractor
                .getWeatherByCityName("Thessaloniki")
                .subscribe(cityWeather -> {
                    name.set(cityWeather.getName());
                    description.set(cityWeather.getWeather().get(0).getDescription());
                    icon.set(cityWeather.getWeather().get(0).getIcon());
                }, throwable -> Log.i(TAG, "call onError : " + throwable.getMessage()));
    }

    public void unBind() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
