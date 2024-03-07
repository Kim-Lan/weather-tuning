package com.kimlan.weathermod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("weathermod");

	public static final WeatherConfig CONFIG = WeatherConfig.createAndLoad();
	public static final IntProvider clearWeatherDurationProvider = UniformIntProvider.create(CONFIG.clearWeatherDuration().get(0), CONFIG.clearWeatherDuration().get(1));
	public static final IntProvider rainWeatherDurationProvider = UniformIntProvider.create(CONFIG.rainWeatherDuration().get(0), CONFIG.rainWeatherDuration().get(1));;
	public static final IntProvider clearThunderWeatherDurationProvider = UniformIntProvider.create(CONFIG.clearThunderWeatherDuration().get(0), CONFIG.clearThunderWeatherDuration().get(1));;
	public static final IntProvider thunderWeatherDurationProvider = UniformIntProvider.create(CONFIG.thunderWeatherDuration().get(0), CONFIG.thunderWeatherDuration().get(1));;


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Weather Mod initialized!");
	}
}