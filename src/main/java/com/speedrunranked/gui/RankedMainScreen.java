package com.speedrunranked.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;

import com.speedrunranked.SpeedrunRankedMod;

public class RankedMainScreen extends Screen {

	private static final int BUTTON_WIDTH = 200;
	private static final int BUTTON_HEIGHT = 40;

	public RankedMainScreen() {
		super(new LiteralText("Speedrun Ranked"));
	}

	@Override
	protected void init() {
		super.init();

		int centerX = this.width / 2;
		int startY = this.height / 2 - 100;

		// Start Ranked Run button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - BUTTON_WIDTH / 2, startY, BUTTON_WIDTH, BUTTON_HEIGHT,
			new LiteralText("Start Ranked Run"),
			button -> startRankedRun()
		));

		// Practice button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - BUTTON_WIDTH / 2, startY + 50, BUTTON_WIDTH, BUTTON_HEIGHT,
			new LiteralText("Practice"),
			button -> openPracticeMenu()
		));

		// Statistics button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - BUTTON_WIDTH / 2, startY + 100, BUTTON_WIDTH, BUTTON_HEIGHT,
			new LiteralText("Statistics"),
			button -> openStatistics()
		));

		// Run History button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - BUTTON_WIDTH / 2, startY + 150, BUTTON_WIDTH, BUTTON_HEIGHT,
			new LiteralText("Run History"),
			button -> openRunHistory()
		));

		// Settings button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - BUTTON_WIDTH / 2, startY + 200, BUTTON_WIDTH, BUTTON_HEIGHT,
			new LiteralText("Settings"),
			button -> openSettings()
		));
	}

	private void startRankedRun() {
		if (SpeedrunRankedMod.runManager != null) {
			SpeedrunRankedMod.runManager.startRankedRun();
			SpeedrunRankedMod.LOGGER.info("[Speedrun Ranked] Starting ranked run...");
		}
	}

	private void openPracticeMenu() {
		this.client.setScreen(new PracticeScreen(this));
	}

	private void openStatistics() {
		this.client.setScreen(new StatisticsScreen(this));
	}

	private void openRunHistory() {
		this.client.setScreen(new RunHistoryScreen(this));
	}

	private void openSettings() {
		this.client.setScreen(new SettingsScreen(this));
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		drawCenteredText(matrices, this.textRenderer, "SPEEDRUN RANKED", this.width / 2, 20, 0xFFFFFF);
		drawCenteredText(matrices, this.textRenderer, "Rating: " + SpeedrunRankedMod.ratingManager.getCurrentRating(), this.width / 2, 40, 0xFFAA00);
		drawCenteredText(matrices, this.textRenderer, "Rank: " + SpeedrunRankedMod.ratingManager.getCurrentRank(), this.width / 2, 55, 0x00FF00);
		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}
}
