package com.data.binding.main.fragments.search;

import com.data.binding.domain.entities.CityWeather;
import com.data.binding.domain.entities.Main;
import com.data.binding.domain.entities.Weather;
import com.data.binding.domain.model.SearchWeatherInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.observers.TestSubscriber;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link SearchViewModel} class.
 */
public class SearchViewModelTest {

    @Mock
    private SearchWeatherInteractor weatherInteractor;

    @Mock
    private Main main;

    @Mock
    private Weather weather;

    private SearchViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        viewModel = new SearchViewModel(weatherInteractor);
    }

    @Test
    public void search() throws Exception {
        when(weatherInteractor.getSearchWeatherByCityName(anyString()))
                .thenReturn(Observable.just(cityWeather()));

        // given
        TestSubscriber<CityWeather> testSubscriber = new TestSubscriber<>();
        weatherInteractor.getSearchWeatherByCityName("Los Angeles").subscribe(testSubscriber);

        // then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(singletonList(cityWeather()));
    }

    private CityWeather cityWeather() {
        return CityWeather.builder()
                .setId(100)
                .setMain(main)
                .setIsFavorite(true)
                .setName("someName")
                .setWeather(asList(weather, weather, weather))
                .build();
    }

}