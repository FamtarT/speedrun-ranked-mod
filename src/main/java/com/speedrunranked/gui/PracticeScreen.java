package com.speedrunranked.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;

import com.speedrunranked.SpeedrunRankedMod;

public class PracticeScreen extends Screen {

	private Screen previousScreen;

	public PracticeScreen(Screen previousScreen) {
		super(new LiteralText("Practice Mode"));
		this.previousScreen = previousScreen;
	}

	@Override
	protected void init() {
		super.init();

		int centerX = this.width / 2;
		int startY = this.height / 2 - 60;

		// Random Seed button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - 100, startY, 200, 40,
			new LiteralText("Random Seed"),
			button -> startPracticeWithRandom()
		));

		// GapCheck Practice button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - 100, startY + 50, 200, 40,
			new LiteralText("GapCheck Seeds"),
			button -> startPracticeWithGapCheck()
		));

		// Back button
		this.addDrawableChild(new net.minecraft.client.gui.widget.ButtonWidget(
			centerX - 50, startY + 100, 100, 30,
			new LiteralText("Back"),
			button -> this.client.setScreen(previousScreen)
		));
	}

	private void startPracticeWithRandom() {
		var seedOpt = SpeedrunRankedMod.seedCache.getNextSeed();
		if (seedOpt.isPresent()) {
			SpeedrunRankedMod.runManager.startPracticeRun(seedOpt.get());
		}
	}

	private void startPracticeWithGapCheck() {
		// Similar to random but with preference for GapCheck
		startPracticeWithRandom();
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		drawCenteredText(matrices, this.textRenderer, "PRACTICE MODE", this.width / 2, 20, 0x00FF00);
		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}
}
