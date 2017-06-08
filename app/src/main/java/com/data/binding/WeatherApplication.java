package com.data.binding;


import android.app.Application;

import com.data.binding.dagger.ApplicationComponent;
import com.data.binding.dagger.ApplicationModule;
import com.data.binding.dagger.DaggerApplicationComponent;
import com.data.binding.dagger.DaggerNetworkComponent;
import com.data.binding.dagger.NetworkComponent;
import com.data.binding.dagger.NetworkModule;

/**
 * Application class builds and provides Dagger Components with Application scope.
 */

public class WeatherApplication extends Application {

    private static ApplicationComponent applicationComponent;
    private static NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        networkComponent = DaggerNetworkComponent.builder()
                .applicationComponent(applicationComponent)
                .networkModule(new NetworkModule())
                .build();

    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

}