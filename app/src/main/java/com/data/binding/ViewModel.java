package com.data.binding;

import android.content.Context;
import android.databinding.ObservableField;

/**
 * Created by css on 6/7/17.
 */

public class ViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();

    private final Context context; //  to avoid leaks this must be an Application Context

    public ViewModel(Context context) {
        this.context = context.getApplicationContext(); // force use of Application context
    }


    public void start(String userId) {
        //do something with the model
    }

}
