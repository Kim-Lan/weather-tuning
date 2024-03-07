package com.kimlan.weathermod;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.PredicateConstraint;

import java.util.ArrayList;
import java.util.List;

@Config(name = "weatherconfig", wrapperName = "WeatherConfig")
public class WeatherConfigModel {

    @PredicateConstraint("predicateFunction")
    public List<Integer> clearWeatherDuration = new ArrayList<Integer>(List.of(12000, 180000));

    @PredicateConstraint("predicateFunction")
    public List<Integer> rainWeatherDuration = new ArrayList<Integer>(List.of(12000, 24000));

    @PredicateConstraint("predicateFunction")
    public List<Integer> clearThunderWeatherDuration = new ArrayList<Integer>(List.of(12000, 180000));

    @PredicateConstraint("predicateFunction")
    public List<Integer> thunderWeatherDuration = new ArrayList<Integer>(List.of(3600, 15600));

    public static boolean predicateFunction(List<Integer> list) {
        return list.size() == 2 && list.get(0) > 0 && list.get(1) > list.get(0);
    }
}
