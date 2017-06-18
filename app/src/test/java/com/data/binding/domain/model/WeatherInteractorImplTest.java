package com.data.binding.domain.model;

import com.data.binding.data.OpenWeatherMapApi;
import com.data.binding.domain.entities.CityWeather;
import com.data.binding.domain.entities.Main;
import com.data.binding.domain.entities.Weather;
import com.data.binding.utils.schedulers.BaseSchedulerProvider;
import com.data.binding.utils.schedulers.ImmediateSchedulerProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.observers.TestSubscriber;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link WeatherInteractorImpl}
 */
public class WeatherInteractorImplTest {

    @Mock
    private OpenWeatherMapApi openWeatherMapApi;

    @Mock
    private Main main;

    @Mock
    private Weather weather;

    private BaseSchedulerProvider schedulerProvider;

    private WeatherInteractor weatherInteractor;

    private final String apiKey = "apiKey";


    @Before
    public void setUp() throws Exception {
        // injects mocks
        MockitoAnnotations.initMocks(this);

        // make sure all schedulers are immediate
        schedulerProvider = new ImmediateSchedulerProvider();

        weatherInteractor = new WeatherInteractorImpl(schedulerProvider, openWeatherMapApi);

    }

    @Test
    public void getWeatherByCityName() throws Exception {

    }

    @Test
    public void getWeatherByCityId() throws Exception {
        // when
        when(openWeatherMapApi.getWeatherByCityId(anyLong(), anyString()))
                .thenReturn(Observable.just(cityWeather()));

        // given
        TestSubscriber<CityWeather> testSubscriber = new TestSubscriber<>();
        weatherInteractor.getWeatherByCityId(100L).subscribe(testSubscriber);

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