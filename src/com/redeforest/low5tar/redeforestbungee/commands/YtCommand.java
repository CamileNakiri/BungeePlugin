package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class YtCommand extends Command {

	public YtCommand() {
		super("youtubers");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage("");
		sender.sendMessage("§f§l YOUTUBERS ONLINE:");
		int i = 0;
		for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
			if (players.hasPermission("com.redeforest.bungee.youtuber")) {
				++i;
				sender.sendMessage(" §f➥ §c[YT] " + players.getName() + " §8- §7(" + players.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ")");
			}
		}
		if (i == 0) {
			sender.sendMessage("§c  Sem YTs online no momento.");
		}
		sender.sendMessage("");
	}
}