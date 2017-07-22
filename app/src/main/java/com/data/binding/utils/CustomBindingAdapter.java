package com.data.binding.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Binds imageUrl String with Picasso.
 */

public class CustomBindingAdapter {

    private static final String BASE_ICON_URL = "http://openweathermap.org/img/w/";

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(createIconUrl(url)).into(imageView);
    }

    private static String createIconUrl(String icon) {
        return BASE_ICON_URL + icon + ".png";
    }
}
