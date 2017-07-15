package com.data.binding.main.fragments.main.dagger;

import com.data.binding.dagger.NetworkComponent;
import com.data.binding.main.MainActivity;
import com.data.binding.main.fragments.main.MainFragment;
import com.data.binding.utils.FragmentScope;

import dagger.Component;

/**
 * Dagger Component which injects dependencies to {@link MainActivity}
 */

@FragmentScope
@Component(dependencies = NetworkComponent.class, modules = {MainFragmentModule.class, WeatherModule.class})
public interface MainFragmentComponent {

    void inject(MainFragment mainFragment);
}
