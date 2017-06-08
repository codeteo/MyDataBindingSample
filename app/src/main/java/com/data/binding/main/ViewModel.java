package com.data.binding.main;

import android.content.Context;
import android.databinding.ObservableField;

import com.data.binding.domain.entities.User;

/**
 * ViewModel layer between View and Model. Binds to the View and reacts to events.
 */

public class ViewModel implements GetUserCallback {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();

    private Model model;

    private final Context context; //  to avoid leaks this must be an Application Context

    public ViewModel(Context context) {
        this.context = context.getApplicationContext(); // force use of Application context
        this.model = new Model();
    }


    public void start(String userId) {
        // some over-engineering magic with the model
        model.getUser(userId, this);
    }

    @Override
    public void onUserLoaded(User user) {
        name.set(user.getName());
        city.set(user.getCity());
        age.set(user.getAge());
    }

    @Override
    public void onUserNotAvailable() {
        // notify user
    }
}
