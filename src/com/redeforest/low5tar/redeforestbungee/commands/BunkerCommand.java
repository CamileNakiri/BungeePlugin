package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.ArrayList;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BunkerCommand extends Command {
	
	public static ArrayList<String> cstaff = new ArrayList<String>();

	public BunkerCommand() {
		super("b");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.bunker")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("§cUtilize /b <mensagem> para enviar uma mensagem para a gerência e direção.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("ativar")) {
				if (!cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat bunker já está ativado.");
					return;
				}
				cstaff.remove(p.getName());
				p.sendMessage("§aChat bunker ativado!");
				return;
			}
			if (args[0].equalsIgnoreCase("desativar")) {
				if (cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat bunker já está desativado.");
					return;
				}
				cstaff.add(p.getName());
				p.sendMessage("§aChat bunker desativado!");
				return;
			}
		}
		if (args.length > 0) {
			String message = "";
			for (String part : args) {
				if (message != "") {
					message = String.valueOf(message) + " ";
				}
				message = String.valueOf(message) + part;
			}
			String tag = "";
			try {
				if (BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Admin"))) {
					tag = "§c[ADMIN]";
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						for (ProxiedPlayer todos : i.getPlayers()) {
							if (todos.hasPermission("com.redeforest.bungee.bunker") && !BunkerCommand.cstaff.contains(todos.getName())) {
								todos.sendMessage("§c§l[§cB§c§l] §7[" + p.getServer().getInfo().getName().replaceAll("Rankup", Main.name_rankup).replaceAll("Lobby", Main.name_lobby) + "] " + tag + " " + p.getName() + ": §f" + message);
							}
						}
					}
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (p.hasPermission("com.redeforest.bungee.coord")) {
				tag = "§d[Coordenador]";
				for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
					for (ProxiedPlayer todos2 : j.getPlayers()) {
						if (todos2.hasPermission("com.redeforest.bungee.bunker") && !BunkerCommand.cstaff.contains(todos2.getName())) {
							todos2.sendMessage("§c§l[§cB§c§l] §7[" + p.getServer().getInfo().getName().replaceAll("Rankup", Main.name_rankup).replaceAll("Lobby", Main.name_lobby) + "] " + tag + " " + p.getName() + ": §f" + message);
						}
					}
				}
			}
		}
	}
}
 