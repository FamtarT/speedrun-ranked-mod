package com.speedrunranked.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;

import net.minecraft.client.world.ClientWorld;
import com.speedrunranked.SpeedrunRankedMod;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {

	@Inject(at = @At("HEAD"), method = "tick", cancellable = true)
	private void onClientWorldTick(CallbackInfo ci) {
		// Client-side tick handling
	}
}
