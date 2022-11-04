package dev.mayaqq.scorebar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.gui.controllers.TickBoxController;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    public static final Config INSTANCE = new Config();

    public final Path configFile = FabricLoader.getInstance().getConfigDir().resolve("scorebar.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public boolean enableScoreboard = true;
    public boolean enabledBossbar = true;

    public void save() {
        try {
            Files.deleteIfExists(configFile);

            JsonObject json = new JsonObject();
            json.addProperty("enableScoreboard", enableScoreboard);
            json.addProperty("enableBossbar", enabledBossbar);

            Files.writeString(configFile, gson.toJson(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            if (Files.notExists(configFile)) {
                save();
                return;
            }

            JsonObject json = gson.fromJson(Files.readString(configFile), JsonObject.class);

            if (json.has("enableScoreboard"))
                enableScoreboard = json.getAsJsonPrimitive("enableScoreboard").getAsBoolean();
            if (json.has("enableBossbar"))
                enabledBossbar = json.getAsJsonPrimitive("enableBossbar").getAsBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Screen makeScreen(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Text.of("Scorebar"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.of("General"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.of("Enable Scoreboard"))
                                .binding(
                                        true,
                                        () -> enableScoreboard,
                                        value -> enableScoreboard = value
                                )
                                .controller(TickBoxController::new)
                                .build())
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.of("Enable Bossbar"))
                                .binding(
                                        true,
                                        () -> enabledBossbar,
                                        value -> enabledBossbar = value
                                )
                                .controller(TickBoxController::new)
                                .build())
                        .build())
                .save(this::save)
                .build()
                .generateScreen(parent);
    }
}
