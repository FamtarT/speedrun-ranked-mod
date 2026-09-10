package com.speedrunranked.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;

import com.speedrunranked.hud.SpeedrunHud;
import com.speedrunranked.SpeedrunRankedMod;

@Environment(EnvType.CLIENT)
public class ClientInitializer {

	private static SpeedrunHud speedrunHud;

	public static void onClientStart() {
		SpeedrunRankedMod.LOGGER.info("[Speedrun Ranked] Client initializing...");

		// Initialize HUD
		MinecraftClient client = MinecraftClient.getInstance();
		speedrunHud = new SpeedrunHud(client);

		// Register event handlers
		ClientEventHandler.register();

		SpeedrunRankedMod.LOGGER.info("[Speedrun Ranked] Client initialized!");
	}

	public static SpeedrunHud getHud() {
		return speedrunHud;
	}
}
