package com.data.binding.main.dagger;

import com.data.binding.dagger.NetworkComponent;
import com.data.binding.main.MainActivity;
import com.data.binding.utils.MainActivityScope;

import dagger.Component;

/**
 * Dagger Component which injects dependencies to {@link MainActivity}
 */

@MainActivityScope
@Component(dependencies = NetworkComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
