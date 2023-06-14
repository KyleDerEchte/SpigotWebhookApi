package de.kyleonaut.webhookplugin;

import de.kyleonaut.webhookplugin.api.WebhookServerBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

import static spark.Spark.*;

public class WebhookPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        port(getConfig().getInt("port"));
        threadPool(32);
        Bukkit.getLogger().log(Level.INFO, "[Webhooks] " + ChatColor.GREEN + "Webhooks initialized!");

        if (getConfig().getBoolean("debug")) {
            WebhookServerBuilder.builder()
                    .key("debug")
                    .handle(() -> Bukkit.getLogger().log(Level.INFO, "[Webhooks] A debug message was received."))
                    .register();
        }

    }

    @Override
    public void onDisable() {
        stop();
    }
}
