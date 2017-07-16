package com.data.binding.main.fragments.search.dagger;

import com.data.binding.domain.model.SearchWeatherInteractor;
import com.data.binding.main.fragments.search.SearchViewModel;
import com.data.binding.utils.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module provides ViewModel for {@link com.data.binding.main.MainActivity}
 */

@Module
public class SearchFragmentModule {

    public SearchFragmentModule() {
    }

    @FragmentScope
    @Provides
    SearchViewModel providesViewModel(SearchWeatherInteractor searchWeatherInteractor) {
        return new SearchViewModel(searchWeatherInteractor);
    }

}

