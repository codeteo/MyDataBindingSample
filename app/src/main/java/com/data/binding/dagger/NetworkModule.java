package com.data.binding.dagger;

import com.data.binding.utils.BaseUrlInterceptor;
import com.data.binding.utils.NetworkScope;
import com.data.binding.utils.schedulers.BaseSchedulerProvider;
import com.data.binding.utils.schedulers.SchedulerProvider;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Module which provides network dependencies.
 */

@Module
public class NetworkModule {

    private static final int CONNECTION_TIMEOUT = 15;

    public NetworkModule() {
    }

    @Provides
    @NetworkScope
    Gson providesGson() {
        return new Gson();
    }

    @Provides
    @NetworkScope
    OkHttpClient providesOkHttpClient(BaseUrlInterceptor baseUrlInterceptor){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.retryOnConnectionFailure(true);
        client.addInterceptor(interceptor);
        client.addInterceptor(baseUrlInterceptor);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        return client.build();
    }

    @Provides
    @NetworkScope
    Retrofit providesRetrofit(HttpUrl baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @NetworkScope
    BaseSchedulerProvider baseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

}