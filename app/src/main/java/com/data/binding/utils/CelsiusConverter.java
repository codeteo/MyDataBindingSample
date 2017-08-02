package com.data.binding.utils;

/**
 * Helper class to convert temperature from Kelvin
 * to Celsius.
 */

public class CelsiusConverter {

    /**
     * Takes temperature in Kelvin and converts it to Celsius.
     * @return the value in Celsius
     */
    public static int convert(double kelvinTemp) {
        return (int) (kelvinTemp - 273.15);
    }

}
