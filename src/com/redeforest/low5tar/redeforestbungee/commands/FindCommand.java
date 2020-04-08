package com.redeforest.low5tar.redeforestbungee.commands;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.ProxyServer;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class FindCommand extends Command {

	public FindCommand() {
		super("find");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission("com.redeforest.bungee.find")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /find <usu�rio>.");
			return;
		}
		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
		if (player == null) {
			sender.sendMessage("�cEste usu�rio n�o est� on-line.");
			return;
		}
		sender.sendMessage("�aO usu�rio " + player.getName() + " est� conectado ao servidor " + player.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ".");
	}
}