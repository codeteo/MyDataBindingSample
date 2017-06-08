package com.data.binding.main;

import com.data.binding.domain.entities.User;

/**
 * Callback interface to notify ViewModel from Model.
 */

public interface GetUserCallback {

    void onUserLoaded(User user);

    void onUserNotAvailable();

}
