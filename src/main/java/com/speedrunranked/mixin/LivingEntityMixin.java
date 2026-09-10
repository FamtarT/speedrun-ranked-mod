package com.speedrunranked.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import com.speedrunranked.SpeedrunRankedMod;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(at = @At("HEAD"), method = "onDeath", cancellable = true)
	private void onPlayerDeath(DamageSource source, CallbackInfo ci) {
		LivingEntity entity = (LivingEntity) (Object) this;

		// Check if it's the player
		if (entity instanceof net.minecraft.entity.player.PlayerEntity) {
			if (SpeedrunRankedMod.runManager != null && SpeedrunRankedMod.runManager.getCurrentRun() != null) {
				SpeedrunRankedMod.LOGGER.info("[Speedrun Ranked] Player died!");
				SpeedrunRankedMod.runManager.failRun();
			}
		}
	}
}
