package com.sunlitkid.center.config;

/**
 * Created by sunke on 2017/8/8.
 */
public class HomeStatus {
    private static Float temperature ;
    private static Float humidity ;
    private static Float luminance ;

    public static Float getTemperature() {
        return temperature;
    }

    public static void setTemperature(Float temperature) {
        HomeStatus.temperature = temperature;
    }

    public static Float getHumidity() {
        return humidity;
    }

    public static void setHumidity(Float humidity) {
        HomeStatus.humidity = humidity;
    }

    public static Float getLuminance() {
        return luminance;
    }

    public static void setLuminance(Float luminance) {
        HomeStatus.luminance = luminance;
    }
}
