package com.data.binding.main.fragments.search;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.data.binding.R;
import com.data.binding.WeatherApplication;
import com.data.binding.databinding.FragmentSearchBinding;
import com.data.binding.domain.entities.CityWeather;
import com.data.binding.main.adapter.CityWeatherAdapter;
import com.data.binding.main.fragments.BaseFragment;
import com.data.binding.main.fragments.search.dagger.DaggerSearchFragmentComponent;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * A screen where user can search for the weather in various places.
 * Displays a searchBar and queries OpenWeatherMap API for every search.
 * Appears when user clicks on search tab.
 */

public class SearchFragment extends BaseFragment {

    private static final String TAG = "SEARCH-FRAGMENT";

    @Inject
    SearchViewModel searchViewModel;

    @NonNull
    private CompositeSubscription compositeSubscription;

    private CityWeatherAdapter adapter;

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        compositeSubscription = new CompositeSubscription();
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

        setupAdapter(binding);

        compositeSubscription.add(searchViewModel
                .search(RxTextView.textChanges(binding.etSearch))
                .subscribe(this::setWeatherList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }

    private void setupAdapter(FragmentSearchBinding binding) {
        adapter = new CityWeatherAdapter();
        binding.rvSearch.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvSearch.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                layoutManager.getOrientation());
        binding.rvSearch.addItemDecoration(dividerItemDecoration);
    }

    private void setWeatherList(CityWeather cityWeather) {
        adapter.updateDataset(cityWeather);
        adapter.notifyDataSetChanged();
    }

}
