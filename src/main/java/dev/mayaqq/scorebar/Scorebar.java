package dev.mayaqq.scorebar;

import net.fabricmc.api.ClientModInitializer;

public class Scorebar implements ClientModInitializer {
	public void onInitializeClient() {
		Config.INSTANCE.load();
	}
}
