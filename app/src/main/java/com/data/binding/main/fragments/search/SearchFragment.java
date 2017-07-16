package com.data.binding.main.fragments.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.data.binding.R;
import com.data.binding.WeatherApplication;
import com.data.binding.databinding.FragmentSearchBinding;
import com.data.binding.main.fragments.BaseFragment;
import com.data.binding.main.fragments.search.dagger.DaggerSearchFragmentComponent;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

/**
 * A screen where user can search for the weather in various places.
 * Displays a searchBar and queries OpenWeatherMap API for every search.
 * Appears when user clicks on search tab.
 */

public class SearchFragment extends BaseFragment {

    @Inject
    SearchViewModel searchViewModel;

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSearchFragmentComponent.builder()
                .networkComponent(WeatherApplication.getNetworkComponent())
                .build()
                .inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSearchBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_search, container, false);

        View view = binding.getRoot();

        binding.setSearchViewModel(searchViewModel);
        searchViewModel.search(RxTextView.textChanges(binding.etSearch));

        return view;
    }

}
