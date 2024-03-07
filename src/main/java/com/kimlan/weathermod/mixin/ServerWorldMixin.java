package com.kimlan.weathermod.mixin;

import static com.kimlan.weathermod.WeatherMod.*;

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
        return thunderWeatherDurationProvider.get(random);
    }

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
                    ordinal = 1
            )
    )
    private int redirectClearThunderWeatherDuration(IntProvider instance, Random random) {
        return clearThunderWeatherDurationProvider.get(random);
    }

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
                    ordinal = 2
            )
    )
    private int redirectRainWeatherDuration(IntProvider instance, Random random) {
        return rainWeatherDurationProvider.get(random);
    }

    @Redirect(method = "tickWeather",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/intprovider/IntProvider;get(Lnet/minecraft/util/math/random/Random;)I",
                    ordinal = 3
            )
    )
    private int redirectClearWeatherDuration(IntProvider instance, Random random) {
        return clearWeatherDurationProvider.get(random);
    }
}
