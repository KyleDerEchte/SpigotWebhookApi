package de.kyleonaut.webhookplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import spark.routematch.RouteMatch;

import static spark.Spark.routes;

public class ShowWebhooksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof ConsoleCommandSender)) {
            sender.sendMessage("§8[§7Webhooks§8] §cThis feature is only available from console.");
            return false;
        }
        try {
            for (RouteMatch route : routes()) {
                String matchUri = route.getMatchUri();
                sender.sendMessage("§8[§7Webhooks§8] §7" + matchUri);
            }
        } catch (NullPointerException e) {
            sender.sendMessage("§8[§7Webhooks§8] §cYou have no webhooks registered.");
        }

        return true;
    }
}
