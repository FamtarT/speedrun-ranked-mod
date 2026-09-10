package com.speedrunranked.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;

import com.speedrunranked.SpeedrunRankedMod;

public class StatisticsScreen extends Screen {

	private Screen previousScreen;

	public StatisticsScreen(Screen previousScreen) {
		super(new LiteralText("Statistics"));
		this.previousScreen = previousScreen;
	}

	@Override
	protected void init() {
		super.init();

		int centerX = this.width / 2;
		int buttonY = this.height - 40;

		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - 50, buttonY, 100, 30,
			new LiteralText("Back"),
			button -> this.client.setScreen(previousScreen)
		));
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);

		int centerX = this.width / 2;
		int startY = 30;
		int lineHeight = 20;

		drawCenteredText(matrices, this.textRenderer, "STATISTICS", centerX, startY, 0x00FF00);

		var playerData = SpeedrunRankedMod.dataManager.getPlayerData();

		if (playerData != null) {
			drawCenteredText(matrices, this.textRenderer, "Current Rating: " + playerData.getCurrentRating(), centerX, startY + lineHeight * 2, 0xFFAA00);
			drawCenteredText(matrices, this.textRenderer, "Current Rank: " + playerData.getCurrentRank(), centerX, startY + lineHeight * 3, 0x00FF00);
			drawCenteredText(matrices, this.textRenderer, "Personal Best: " + String.format("%.2f", playerData.getPersonalBestTime()) + "s", centerX, startY + lineHeight * 4, 0xFFFFFF);
			drawCenteredText(matrices, this.textRenderer, "Average Time: " + String.format("%.2f", playerData.getAverageTime()) + "s", centerX, startY + lineHeight * 5, 0xFFFFFF);
			drawCenteredText(matrices, this.textRenderer, "Total Runs: " + playerData.getTotalRuns(), centerX, startY + lineHeight * 6, 0xFFFFFF);
			drawCenteredText(matrices, this.textRenderer, "Completed: " + playerData.getCompletedRuns(), centerX, startY + lineHeight * 7, 0x00FF00);
			drawCenteredText(matrices, this.textRenderer, "Failed: " + playerData.getFailedRuns(), centerX, startY + lineHeight * 8, 0xFF0000);
		}

		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}
}
