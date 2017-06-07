package com.data.binding;

/**
 * Created by css on 6/7/17.
 */

public interface GetUserCallback {

    void onUserLoaded(User user);

    void onUserNotAvailable();

}
