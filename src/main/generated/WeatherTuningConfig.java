package com.kimlan.weathertuning;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class WeatherTuningConfig extends ConfigWrapper<com.kimlan.weathertuning.WeatherTuningConfigModel> {

    public final Keys keys = new Keys();

    private final Option<java.util.List<java.lang.Integer>> clearWeatherDuration = this.optionForKey(this.keys.clearWeatherDuration);
    private final Option<java.util.List<java.lang.Integer>> rainWeatherDuration = this.optionForKey(this.keys.rainWeatherDuration);
    private final Option<java.util.List<java.lang.Integer>> clearThunderWeatherDuration = this.optionForKey(this.keys.clearThunderWeatherDuration);
    private final Option<java.util.List<java.lang.Integer>> thunderWeatherDuration = this.optionForKey(this.keys.thunderWeatherDuration);

    private WeatherTuningConfig() {
        super(com.kimlan.weathertuning.WeatherTuningConfigModel.class);
    }

    private WeatherTuningConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(com.kimlan.weathertuning.WeatherTuningConfigModel.class, janksonBuilder);
    }

    public static WeatherTuningConfig createAndLoad() {
        var wrapper = new WeatherTuningConfig();
        wrapper.load();
        return wrapper;
    }

    public static WeatherTuningConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new WeatherTuningConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public java.util.List<java.lang.Integer> clearWeatherDuration() {
        return clearWeatherDuration.value();
    }

    public void clearWeatherDuration(java.util.List<java.lang.Integer> value) {
        clearWeatherDuration.set(value);
    }

    public java.util.List<java.lang.Integer> rainWeatherDuration() {
        return rainWeatherDuration.value();
    }

    public void rainWeatherDuration(java.util.List<java.lang.Integer> value) {
        rainWeatherDuration.set(value);
    }

    public java.util.List<java.lang.Integer> clearThunderWeatherDuration() {
        return clearThunderWeatherDuration.value();
    }

    public void clearThunderWeatherDuration(java.util.List<java.lang.Integer> value) {
        clearThunderWeatherDuration.set(value);
    }

    public java.util.List<java.lang.Integer> thunderWeatherDuration() {
        return thunderWeatherDuration.value();
    }

    public void thunderWeatherDuration(java.util.List<java.lang.Integer> value) {
        thunderWeatherDuration.set(value);
    }


    public static class Keys {
        public final Option.Key clearWeatherDuration = new Option.Key("clearWeatherDuration");
        public final Option.Key rainWeatherDuration = new Option.Key("rainWeatherDuration");
        public final Option.Key clearThunderWeatherDuration = new Option.Key("clearThunderWeatherDuration");
        public final Option.Key thunderWeatherDuration = new Option.Key("thunderWeatherDuration");
    }
}

