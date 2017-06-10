package com.data.binding.main;

import com.data.binding.domain.entities.User;

/**
 * Contract defining business logic of {@link MainActivity}
 */

public interface MainModel {

    User getUser(String userId, GetUserCallback callback);

}
