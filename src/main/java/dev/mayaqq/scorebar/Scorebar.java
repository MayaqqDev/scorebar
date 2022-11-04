package dev.mayaqq.scorebar;

import net.fabricmc.api.ModInitializer;

public class Scorebar implements ModInitializer {
	@Override
	public void onInitialize() {
		getConfig().load();
	}
	public static Config getConfig() {
		return Config.INSTANCE;
	}
}
