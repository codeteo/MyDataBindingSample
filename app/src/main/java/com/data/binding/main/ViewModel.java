package com.data.binding.main;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.data.binding.domain.entities.CityWeather;
import com.data.binding.domain.entities.User;
import com.data.binding.domain.model.WeatherInteractor;

import javax.inject.Inject;

import rx.functions.Action1;

import static android.databinding.DynamicUtil.safeUnbox;

/**
 * ViewModel layer between View and Model. Binds to the View and reacts to events.
 */

public class ViewModel implements GetUserCallback {

    public static final String TAG = "VIEW-MODEL";

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();

    @NonNull
    private WeatherInteractor weatherInteractor;

    @Inject
    public ViewModel(@NonNull WeatherInteractor weatherInteractor) {
        this.weatherInteractor = weatherInteractor;
    }

    public void start() {
        weatherInteractor
                .getWeatherByCityName("Thessaloniki")
                .subscribe(new Action1<CityWeather>() {
                    @Override
                    public void call(CityWeather cityWeather) {
                        Log.i(TAG, "call Do something here");
                        name.set(cityWeather.getWeather().get(0).getDescription());

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i(TAG, "call onError : " + throwable.getMessage());
                    }
                });
    }

    @Override
    public void onUserLoaded(User user) {
        name.set(user.getName());
        city.set(user.getCity());
        age.set(safeUnbox(user.getAge()));
    }

    @Override
    public void onUserNotAvailable() {
        // notify user
    }
}
