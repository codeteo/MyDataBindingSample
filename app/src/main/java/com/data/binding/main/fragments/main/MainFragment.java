package com.data.binding.main.fragments.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.data.binding.R;
import com.data.binding.WeatherApplication;
import com.data.binding.databinding.FragmentMainBinding;
import com.data.binding.main.fragments.BaseFragment;
import com.data.binding.main.fragments.main.dagger.DaggerMainFragmentComponent;

import javax.inject.Inject;

/**
 * Serves as the screen for the first tab of the bottom bar.
 * Displays SKG weather by default.
 */

public class MainFragment extends BaseFragment {

    @Inject
    MainViewModel viewModel;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_main, container, false);

        View view = binding.getRoot();

        DaggerMainFragmentComponent.builder()
                .networkComponent(WeatherApplication.getNetworkComponent())
                .build()
                .inject(this);

        binding.setViewModel(viewModel);

        viewModel.start();

        return view;
    }
}
