package com.data.binding.main.fragments.settings;

import android.os.Bundle;

import com.data.binding.main.fragments.BaseFragment;

/**
 * A screen displaying settings.
 * Appears when user clicks on settings tab.
 */

public class SettingsFragment extends BaseFragment {

    public static SettingsFragment newInstance() {

        Bundle args = new Bundle();

        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
