package com.data.binding.dagger;


import com.data.binding.utils.NetworkScope;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Exposes dependencies to be used by other modules.
 */

@NetworkScope
@Component(dependencies = ApplicationComponent.class, modules = NetworkModule.class)
public interface NetworkComponent {

    OkHttpClient okHttpClient();

    Retrofit retrofit();

}