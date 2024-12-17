package com.kimlan.weathertuning.mixin;

import static com.kimlan.weathertuning.WeatherTuning.*;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
	 				target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
	 				ordinal = 0
            )
    )
    private int redirectThunderWeatherDuration(IntProvider instance, Random random) {
        int duration = thunderWeatherDurationProvider.get(random);
        if (CONFIG.printToConsole()) {
            LOGGER.info("[Weather Tuning] Thunder weather duration set to " + duration);
        }
        return duration;
    }

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
                    ordinal = 1
            )
    )
    private int redirectClearThunderWeatherDuration(IntProvider instance, Random random) {
        int duration = clearThunderWeatherDurationProvider.get(random);
        if (CONFIG.printToConsole()) {
            LOGGER.info("[Weather Tuning] Clear thunder weather duration set to " + duration);
        }
        return duration;
    }

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
                    ordinal = 2
            )
    )
    private int redirectRainWeatherDuration(IntProvider instance, Random random) {
        int duration = rainWeatherDurationProvider.get(random);
        if (CONFIG.printToConsole()) {
            LOGGER.info("[Weather Tuning] Rain weather duration set to " + duration);
        }
        return duration;
    }

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
                    ordinal = 3
            )
    )
    private int redirectClearWeatherDuration(IntProvider instance, Random random) {
        int duration = clearWeatherDurationProvider.get(random);
        if (CONFIG.printToConsole()) {
            LOGGER.info("[Weather Tuning] Clear weather duration set to " + duration);
        }
        return duration;
    }
}
