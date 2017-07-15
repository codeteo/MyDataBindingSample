package com.data.binding.main.fragments.main.dagger;

import com.data.binding.domain.model.WeatherInteractor;
import com.data.binding.main.fragments.main.MainViewModel;
import com.data.binding.utils.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module provides ViewModel for {@link com.data.binding.main.MainActivity}
 */

@Module
public class MainFragmentModule {

    public MainFragmentModule() {
    }

    @FragmentScope
    @Provides
    MainViewModel providesViewModel(WeatherInteractor weatherInteractor) {
        return new MainViewModel(weatherInteractor);
    }

}
