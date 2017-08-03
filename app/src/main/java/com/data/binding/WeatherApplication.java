package com.data.binding;


import android.app.Application;

import com.data.binding.dagger.ApplicationComponent;
import com.data.binding.dagger.ApplicationModule;
import com.data.binding.dagger.DaggerApplicationComponent;
import com.data.binding.dagger.DaggerDataComponent;
import com.data.binding.dagger.DaggerNetworkComponent;
import com.data.binding.dagger.DataComponent;
import com.data.binding.dagger.NetworkComponent;
import com.data.binding.dagger.NetworkModule;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Application class builds and provides Dagger Components with Application scope.
 */

public class WeatherApplication extends Application {

    private static ApplicationComponent applicationComponent;
    private static NetworkComponent networkComponent;
    private static DataComponent dataComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        networkComponent = DaggerNetworkComponent.builder()
                .applicationComponent(applicationComponent)
                .networkModule(new NetworkModule())
                .build();

        dataComponent = DaggerDataComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    public static DataComponent getDataComponent() {
        return dataComponent;
    }

}