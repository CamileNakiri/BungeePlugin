package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerCommand extends Command {
	
	public ServerCommand() {
		super("server");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.server")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /server <servidor> para se conectar � um servidor.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("listar")) {
				p.sendMessage("");
				p.sendMessage("�a Servidores conectados ao BungeeCord:");
				for (String s : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
					p.sendMessage("�a  " + i.getName());
				}
				p.sendMessage("");
				return;
			}
			String servidor = args[0].toLowerCase();
			if (Main.getInstance().getProxy().getServers().get(servidor) == null) {
				p.sendMessage("�cServidor n�o encontrado.");
				return;
			}
			ServerInfo i = Main.getInstance().getProxy().getServers().get(servidor);
			if (i.equals((p.getServer().getInfo()))) {
				p.sendMessage("�cVoc� j� est� conectado � este servidor.");
				return;
			}
			p.sendMessage("�aEnviando " + p.getName() + " para o servidor " + i.getName().toLowerCase().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ".");
			p.connect(i);
		}
		if (args.length == 2) {
			int ia = 0;
			ProxiedPlayer p1 = null;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
				for (ProxiedPlayer todos : i.getPlayers()) {
					if (!todos.getName().equalsIgnoreCase(args[0]))
						continue;
					p1 = todos;
					++ia;
				}
			}
			if (ia == 0) {
				p.sendMessage("�cEste usu�rio n�o est� online.");
				return;
			}
			String servidor = args[1].toLowerCase();
			if (Main.getInstance().getProxy().getServers().get(servidor) == null) {
				p.sendMessage("�cServidor n�o encontrado.");
				return;
			}
			ServerInfo i = Main.getInstance().getProxy().getServers().get(servidor);
			if (i.equals((p1.getServer().getInfo()))) {
				p.sendMessage("�cEste usu�rio j� est� conectado � este servidor.");
				return;
			}
			p.sendMessage("�aEnviando " + p1.getName() + " para o servidor " + i.getName().toLowerCase().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ".");
			p1.connect(i);
		}
	}
}
