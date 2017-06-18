package com.data.binding.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.data.binding.R;
import com.data.binding.WeatherApplication;
import com.data.binding.databinding.ActivityMainBinding;
import com.data.binding.main.dagger.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DaggerMainActivityComponent.builder()
                .networkComponent(WeatherApplication.getNetworkComponent())
                .build()
                .inject(this);

        binding.setViewModel(viewModel);

        viewModel.start();
    }

/*
    public void setViewModel(@NonNull ViewModel viewModel) {
        this.viewModel = checkNotNull(viewModel);
    }
*/

}
