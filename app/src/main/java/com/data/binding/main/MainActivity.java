package com.data.binding.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.data.binding.R;
import com.data.binding.main.fragments.main.MainFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main_container, MainFragment.newInstance())
                .commit();

    }

}
