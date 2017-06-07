package com.data.binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.data.binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        User jordan = new User();
        jordan.setName("Michael Jordan");
        jordan.setCity("Chicago");
        jordan.setAge(55);

        binding.setUser(jordan);

    }

}
