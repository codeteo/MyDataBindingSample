package com.data.binding.dagger;


import com.data.binding.utils.MainActivityScope;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Exposes dependencies to be used by other modules.
 */

@MainActivityScope
@Component(dependencies = ApplicationComponent.class, modules = NetworkModule.class)
public interface NetworkComponent {

    OkHttpClient okHttpClient();

    Retrofit retrofit();

}