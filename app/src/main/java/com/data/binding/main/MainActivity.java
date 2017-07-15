package com.data.binding.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.data.binding.R;
import com.data.binding.main.fragments.favorites.FavoriteFragment;
import com.data.binding.main.fragments.main.MainFragment;
import com.data.binding.main.fragments.search.SearchFragment;
import com.data.binding.main.fragments.settings.SettingsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bb_bottom_bar_view) BottomNavigationView bottomBar;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main_container, MainFragment.newInstance())
                .commit();

        bottomBar.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            fragment = MainFragment.newInstance();
                            break;
                        case R.id.action_search:
                            fragment = SearchFragment.newInstance();
                            break;
                        case R.id.action_favorite:
                            fragment = FavoriteFragment.newInstance();
                            break;
                        case R.id.action_settings:
                            fragment = SettingsFragment.newInstance();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_main_container, fragment)
                            .commit();

                    return true;
                }
            });

    }

}
