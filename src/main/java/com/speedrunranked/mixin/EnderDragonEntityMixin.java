package com.speedrunranked.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import com.speedrunranked.SpeedrunRankedMod;

@Mixin(EnderDragonEntity.class)
public class EnderDragonEntityMixin {

	@Inject(at = @At("HEAD"), method = "onDeath", cancellable = true)
	private void onDeath(DamageSource source, CallbackInfo ci) {
		if (SpeedrunRankedMod.runManager != null && SpeedrunRankedMod.runManager.getCurrentRun() != null) {
			SpeedrunRankedMod.LOGGER.info("[Speedrun Ranked] Ender Dragon defeated!");
			SpeedrunRankedMod.runManager.completeRun();
		}
	}
}
