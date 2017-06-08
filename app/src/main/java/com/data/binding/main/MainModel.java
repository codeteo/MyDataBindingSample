package com.data.binding.main;

import com.data.binding.domain.entities.User;

/**
 * Created by css on 6/8/17.
 */

public interface MainModel {

    User getUser(String userId, GetUserCallback callback);

}
