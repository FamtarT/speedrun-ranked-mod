package com.speedrunranked.hud;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import com.speedrunranked.SpeedrunRankedMod;
import com.speedrunranked.run.RunState;

@Environment(EnvType.CLIENT)
public class SpeedrunHud extends DrawableHelper {

	private MinecraftClient client;

	public SpeedrunHud(MinecraftClient client) {
		this.client = client;
	}

	public void render(MatrixStack matrices) {
		if (SpeedrunRankedMod.runManager == null || SpeedrunRankedMod.runManager.getCurrentRun() == null) {
			return;
		}

		var currentRun = SpeedrunRankedMod.runManager.getCurrentRun();
		var state = currentRun.getState();

		if (state == RunState.COUNTDOWN) {
			renderCountdown(matrices);
		} else if (state == RunState.RUNNING) {
			renderTimer(matrices);
		}
	}

	private void renderCountdown(MatrixStack matrices) {
		String text = String.valueOf(SpeedrunRankedMod.runManager.getCountdownRemaining());
		if (SpeedrunRankedMod.runManager.getCountdownRemaining() <= 0) {
			text = "GO!";
		}

		int x = this.client.getWindow().getScaledWidth() / 2;
		int y = this.client.getWindow().getScaledHeight() / 2;

		drawCenteredString(matrices, this.client.textRenderer, text, x, y, 0xFF00FF);
	}

	private void renderTimer(MatrixStack matrices) {
		var currentRun = SpeedrunRankedMod.runManager.getCurrentRun();
		String timerText = currentRun.getTimer().getFormattedTime();

		int x = 10;
		int y = 10;

		MatrixStack ms = new MatrixStack();
		ms.push();

		// Draw timer
		this.client.textRenderer.draw(ms, "RANKED", x, y, 0xFF00FF);
		this.client.textRenderer.draw(ms, timerText, x, y + 10, 0xFFFFFF);
		this.client.textRenderer.draw(ms, "Rank: " + SpeedrunRankedMod.ratingManager.getCurrentRank(), x, y + 20, 0x00FF00);
		this.client.textRenderer.draw(ms, "ELO: " + SpeedrunRankedMod.ratingManager.getCurrentRating(), x, y + 30, 0xFFAA00);

		ms.pop();
	}
}
