package com.kimlan.weathermod.mixin;

import static com.kimlan.weathermod.WeatherMod.*;

import net.minecraft.server.command.WeatherCommand;
import net.minecraft.util.math.intprovider.IntProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
@Mixin(WeatherCommand.class)
public class WeatherCommandMixin {
    @ModifyArg(method = "executeClear",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/command/WeatherCommand;processDuration(Lnet/minecraft/server/command/ServerCommandSource;ILnet/minecraft/util/math/intprovider/IntProvider;)I"
            ),
            index = 2
    )
    private static IntProvider modifyExecuteClear(IntProvider provider) {
        return clearWeatherDurationProvider;
    }

    @ModifyArg(method = "executeRain",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/command/WeatherCommand;processDuration(Lnet/minecraft/server/command/ServerCommandSource;ILnet/minecraft/util/math/intprovider/IntProvider;)I"
            ),
            index = 2
    )
    private static IntProvider modifyExecuteRain(IntProvider provider) {
        return rainWeatherDurationProvider;
    }

    @ModifyArg(method = "executeThunder",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/command/WeatherCommand;processDuration(Lnet/minecraft/server/command/ServerCommandSource;ILnet/minecraft/util/math/intprovider/IntProvider;)I"
            ),
            index = 2
    )
    private static IntProvider modifyExecuteThunder(IntProvider provider) {
        return thunderWeatherDurationProvider;
    }
}
