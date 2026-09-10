package com.speedrunranked.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;

public class SettingsScreen extends Screen {

	private Screen previousScreen;

	public SettingsScreen(Screen previousScreen) {
		super(new LiteralText("Settings"));
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
		drawCenteredText(matrices, this.textRenderer, "SETTINGS", this.width / 2, 30, 0x00FF00);
		drawCenteredText(matrices, this.textRenderer, "(Settings coming soon)", this.width / 2, 60, 0xFFFFFF);
		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public boolean shouldCloseOnEsc() {
		return true;
	}
}
