package com.data.binding.main.fragments.favorites;

import android.os.Bundle;

import com.data.binding.main.fragments.BaseFragment;

/**
 * A screen displaying weather for favorite places of the user.
 * Appears when user clicks on favorite tab.
 */

public class FavoriteFragment extends BaseFragment {

    public static FavoriteFragment newInstance() {

        Bundle args = new Bundle();

        FavoriteFragment fragment = new FavoriteFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
