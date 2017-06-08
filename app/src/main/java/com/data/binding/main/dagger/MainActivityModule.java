package com.data.binding.main.dagger;

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

    /** well basically it's an Interactor and not model **/
    @MainActivityScope
    @Provides
    Model providesModel() {
        return new Model();
    }

    @MainActivityScope
    @Provides
    ViewModel providesViewModel(Model model) {
        return new ViewModel(model);
    }

}
