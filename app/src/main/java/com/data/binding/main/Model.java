package com.data.binding.main;

import com.data.binding.domain.entities.CityWeather;
import com.data.binding.domain.entities.User;

import rx.Observable;

import static android.R.attr.apiKey;

/**
 * Model layer containing business logic.
 */

public class Model implements MainModel{

    public Model() {
    }

    public User getUser(String userId, GetUserCallback callback) {
        // ...something complicated here using userId...

        User jordan = new User();
        jordan.setName("Michael Jordan");
        jordan.setCity("Chicago");
        jordan.setAge(55);

        callback.onUserLoaded(jordan);

        return jordan;
    }

    //TODO: Implement caching
    public Observable<CityWeather> getWeatherByCityName(String name) {

        return openWeatherMapService
                .getWeatherByCityName(name, apiKey);
    }

    public Observable<CityWeather> getWeatherByCityId(long id) {

        return openWeatherMapService
                .getWeatherByCityId(id, apiKey);
    }


}
