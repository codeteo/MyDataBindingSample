package com.data.binding.main;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.data.binding.domain.entities.CityWeather;
import com.data.binding.domain.entities.User;
import com.data.binding.domain.model.WeatherInteractor;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * ViewModel layer between View and Model. Binds to the View and reacts to events.
 */

public class ViewModel implements GetUserCallback {

    private static final String TAG = "VIEW-MODEL";
    private static final String BASE_ICON_URL = "http://openweathermap.org/img/w/";

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> icon = new ObservableField<>();

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
                        name.set(cityWeather.getName());
                        description.set(cityWeather.getWeather().get(0).getDescription());
                        icon.set(createIconUrl(cityWeather.getWeather().get(0).getIcon()));
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
        description.set(user.getCity());
    }

    @Override
    public void onUserNotAvailable() {
        // notify user
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    private String createIconUrl(String icon) {
        return BASE_ICON_URL + icon + ".png";
    }
}
