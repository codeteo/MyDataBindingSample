package com.data.binding.dagger;

import android.app.Application;
import android.content.SharedPreferences;

import com.data.binding.utils.BaseUrlInterceptor;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.HttpUrl;

/**
 * Dagger Component for {@link ApplicationModule}
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // exposed dependencies to other modules
    Application getApplication();

    SharedPreferences getSharedPreferences();

    HttpUrl baseUrl();

    // exposes Interceptor to use it for testing with mockWebServer
    BaseUrlInterceptor baseUrlInterceptor();

}