package com.data.binding.domain.entities;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Inner class for {@link CityWeather}
 */

@AutoValue
public abstract class Main implements Parcelable{

    public abstract double getTemp();
    public abstract double getPressure();
    public abstract double getHumidity();

    @SerializedName("temp_min")
    public abstract double getTempMin();

    @SerializedName("temp_max")
    public abstract double getTempMax();

}
