package com.data.binding.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.data.binding.R;
import com.data.binding.databinding.ActivityMainBinding;

import static com.data.binding.utils.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity {

    private ViewModel viewModel;

    private String someUserId = "14";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setViewModel(new ViewModel(this));

        binding.setViewModel(viewModel);

        viewModel.start(someUserId);
    }

    public void setViewModel(@NonNull ViewModel viewModel) {
        this.viewModel = checkNotNull(viewModel);
    }

}
