package com.speedrunranked.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.callback.CallbackInfo;

import net.minecraft.world.GameMode;
import net.minecraft.server.network.ServerPlayerEntity;
import com.speedrunranked.integrity.InvalidReason;
import com.speedrunranked.SpeedrunRankedMod;

@Mixin(ServerPlayerEntity.class)
public class GameModeChangeMixin {

	private GameMode previousGameMode = null;

	@Inject(at = @At("HEAD"), method = "changeGameMode", cancellable = true)
	private void onGameModeChange(GameMode gameMode, CallbackInfo ci) {
		if (SpeedrunRankedMod.runManager != null && SpeedrunRankedMod.runManager.getCurrentRun() != null) {
			if (previousGameMode != null && !previousGameMode.equals(gameMode)) {
				SpeedrunRankedMod.LOGGER.warn("[Speedrun Ranked] Game mode changed: " + gameMode.getName());
				
				if (SpeedrunRankedMod.runManager.getCurrentRun().isRanked()) {
					SpeedrunRankedMod.runManager.getCurrentRun().invalidateRun(InvalidReason.GAME_MODE_CHANGED.getMessage());
				}
			}
		}
		previousGameMode = gameMode;
	}
}
