package com.speedrunranked.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;

import com.speedrunranked.SpeedrunRankedMod;
import com.speedrunranked.run.SpeedrunRun;

public class RunResultScreen extends Screen {

	private SpeedrunRun run;
	private Screen previousScreen;

	public RunResultScreen(SpeedrunRun run, Screen previousScreen) {
		super(new LiteralText("Run Complete"));
		this.run = run;
		this.previousScreen = previousScreen;
	}

	@Override
	protected void init() {
		super.init();

		int centerX = this.width / 2;
		int buttonY = this.height - 60;

		// Next Run button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - 100, buttonY, 90, 40,
			new LiteralText("Next Run"),
			button -> nextRun()
		));

		// Return to Menu button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX + 10, buttonY, 90, 40,
			new LiteralText("Menu"),
			button -> returnToMenu()
		));
	}

	private void nextRun() {
		if (run.isRanked()) {
			SpeedrunRankedMod.runManager.startRankedRun();
		} else {
			this.client.setScreen(new PracticeScreen(previousScreen));
		}
	}

	private void returnToMenu() {
		this.client.setScreen(new RankedMainScreen());
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);

		int centerX = this.width / 2;
		int startY = 30;

		drawCenteredText(matrices, this.textRenderer, "RUN COMPLETE", centerX, startY, 0x00FF00);
		drawCenteredText(matrices, this.textRenderer, "", centerX, startY + 20, 0xFFFFFF);

		drawCenteredText(matrices, this.textRenderer, "Time: " + run.getTimer().getFormattedTime(), centerX, startY + 40, 0xFFFFFF);
		drawCenteredText(matrices, this.textRenderer, "Seed Type: " + run.getSeedInfo().getSeedType(), centerX, startY + 60, 0xFFFFFF);

		if (run.isRanked()) {
			drawCenteredText(matrices, this.textRenderer, "Rating: " + run.getRatingBefore() + " → " + run.getRatingAfter(), centerX, startY + 80, 0xFFAA00);
			drawCenteredText(matrices, this.textRenderer, "Change: " + (run.getRatingChange() > 0 ? "+" : "") + run.getRatingChange(), centerX, startY + 100, run.getRatingChange() > 0 ? 0x00FF00 : 0xFF0000);
		}

		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return false;
	}
}
