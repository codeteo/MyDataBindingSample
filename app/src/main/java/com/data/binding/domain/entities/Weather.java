package com.data.binding.domain.entities;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Inner class for {@link CityWeather}
 */
@AutoValue
public abstract class Weather implements Parcelable{

    public abstract int getId();
    public abstract String getMain();
    public abstract String getDescription();
    public abstract String getIcon();

}
