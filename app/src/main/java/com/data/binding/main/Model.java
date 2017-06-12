package com.data.binding.main;

import com.data.binding.domain.entities.User;

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

}
