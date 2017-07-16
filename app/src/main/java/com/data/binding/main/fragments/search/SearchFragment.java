package com.data.binding.main.fragments.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.data.binding.R;
import com.data.binding.WeatherApplication;
import com.data.binding.main.fragments.BaseFragment;
import com.data.binding.main.fragments.search.dagger.DaggerSearchFragmentComponent;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A screen where user can search for the weather in various places.
 * Displays a searchBar and queries OpenWeatherMap API for every search.
 * Appears when user clicks on search tab.
 */

public class SearchFragment extends BaseFragment {

    @BindView(R.id.et_search) EditText etSearchView;
    @BindView(R.id.rv_search) RecyclerView rvResults;

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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);

        searchViewModel.search(RxTextView.textChanges(etSearchView));

        return view;
    }

}
