package com.data.binding.dagger;

import com.data.binding.utils.DatabaseScope;

import dagger.Component;

/**
 * Dagger Component for {@link DataModule}
 */
@DatabaseScope
@Component(dependencies = ApplicationComponent.class, modules = DataModule.class)
public interface DataComponent {
}
