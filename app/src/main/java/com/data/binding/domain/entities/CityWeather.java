package com.data.binding.domain.entities;

import android.os.Parcelable;

import com.data.binding.data.OpenWeatherMapApi;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Entity class models the response from network request {@link OpenWeatherMapApi}
 */
@AutoValue
public abstract class CityWeather implements Parcelable{

    @SerializedName("id") public abstract long getId();
    @SerializedName("name") public abstract String getName();
    @SerializedName("weather") public abstract List<Weather> getWeather();
    @SerializedName("main") public abstract Main getMain();
    @SerializedName("isFavorite") public abstract boolean getIsFavorite();

}
