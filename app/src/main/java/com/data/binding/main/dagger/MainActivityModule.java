package com.data.binding.main.dagger;

import com.data.binding.domain.model.WeatherInteractor;
import com.data.binding.main.Model;
import com.data.binding.main.ViewModel;
import com.data.binding.utils.MainActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module provides ViewModel for {@link com.data.binding.main.MainActivity}
 */

@Module
public class MainActivityModule {

    public MainActivityModule() {
    }

    @MainActivityScope
    @Provides
    ViewModel providesViewModel(WeatherInteractor weatherInteractor) {
        return new ViewModel(weatherInteractor);
    }

}
