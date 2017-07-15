package com.data.binding.main.fragments.search;

import android.os.Bundle;

import com.data.binding.main.fragments.BaseFragment;

/**
 * A screen where user can search for the weather in various places.
 * Displays a searchBar and queries OpenWeatherMap API for every search.
 * Appears when user clicks on search tab.
 */

public class SearchFragment extends BaseFragment {

    public static SearchFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
