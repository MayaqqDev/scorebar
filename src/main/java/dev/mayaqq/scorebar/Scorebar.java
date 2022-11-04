package dev.mayaqq.scorebar;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.mayaqq.scorebar.integrations.ModMenuIntegration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scorebar implements ModInitializer {
	@Override
	public void onInitialize() {
		getConfig().load();
	}
	public static Config getConfig() {
		return Config.INSTANCE;
	}
}
