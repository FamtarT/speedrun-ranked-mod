package com.speedrunranked.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;

import net.minecraft.server.world.ServerWorld;
import com.speedrunranked.SpeedrunRankedMod;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

	@Inject(at = @At("HEAD"), method = "tick", cancellable = true)
	private void onWorldTick(CallbackInfo ci) {
		if (SpeedrunRankedMod.runManager != null) {
			SpeedrunRankedMod.runManager.tick();
		}
	}
}
