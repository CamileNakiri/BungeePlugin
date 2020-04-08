package com.redeforest.low5tar.redeforestbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ClearChatCommand extends Command {

	public ClearChatCommand() {
		super("limparchat");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (!cs.hasPermission("com.redeforest.bungee.clearchat")) {
			cs.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (cs instanceof ProxiedPlayer) {
			for (int i = 0; i < 300; i++) {
				for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
					on.sendMessage("");
				}
			}
		}
		return;
	}
}
