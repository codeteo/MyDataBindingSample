package com.data.binding;

/**
 * Created by css on 6/7/17.
 */

public class Model {

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
