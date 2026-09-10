package com.speedrunranked.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import com.speedrunranked.SpeedrunRankedMod;
import com.speedrunranked.run.RunState;

@Environment(EnvType.CLIENT)
public class ClientEventHandler {

	private static KeyBinding resetKeyBinding;

	public static void register() {
		// Register reset keybinding
		resetKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.speedrun-ranked-mod.reset",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_R,
			"category.speedrun-ranked-mod.speedrun"
		));

		// Register client tick event
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && client.world != null) {
				onClientTick();
			}
		});
	}

	private static void onClientTick() {
		if (resetKeyBinding.wasPressed()) {
			onResetPressed();
		}
	}

	private static void onResetPressed() {
		if (SpeedrunRankedMod.runManager == null) return;

		var currentRun = SpeedrunRankedMod.runManager.getCurrentRun();
		if (currentRun != null && currentRun.getState() != RunState.IDLE) {
			SpeedrunRankedMod.LOGGER.info("[Speedrun Ranked] Reset triggered");
			SpeedrunRankedMod.runManager.resetRun();
		}
	}
}
