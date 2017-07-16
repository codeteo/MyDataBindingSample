package com.data.binding.main.fragments.search.dagger;

import com.data.binding.dagger.NetworkComponent;
import com.data.binding.main.fragments.main.dagger.WeatherModule;
import com.data.binding.main.fragments.search.SearchFragment;
import com.data.binding.utils.FragmentScope;

import dagger.Component;

/**
 * Dagger Component which injects dependencies to {@link com.data.binding.main.fragments.search.SearchFragment}
 */

@FragmentScope
@Component(dependencies = NetworkComponent.class, modules = {SearchFragmentModule.class, WeatherModule.class})
public interface SearchFragmentComponent {

    void inject(SearchFragment searchFragment);
}

