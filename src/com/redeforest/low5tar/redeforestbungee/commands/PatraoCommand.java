package com.redeforest.low5tar.redeforestbungee.commands;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.redeforest.low5tar.redeforestbungee.Main;

import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PatraoCommand extends Command {
	
	public PatraoCommand() {
		super("!");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.patrao")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		try {
		} catch (Exception exception) {
		}
		if (!BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Admin"))) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /! <mensagem> para enviar uma mensagem incrivelmente deliciosa.");
			return;
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
			if (p.hasPermission("com.redeforest.bungee.coordenador")) {
				tag = "�d[Coordenador]";
			}
			try {
				if (BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Admin"))) {
					tag = "�c[Admin]";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			out.writeUTF("PatraoChannel");
			out.writeUTF("Toque");
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = (ServerInfo) Main.getInstance().getProxy().getServers().get(s);
				for (ProxiedPlayer todos : i.getPlayers()) {
					todos.getServer().sendData("PatraoChannel", out.toByteArray());
					todos.sendMessage("");
					todos.sendMessage(String.valueOf(tag) + " " + p.getName() + ": �f" + message.replace("&", "�"));
					todos.sendMessage("");
				}
			}
		}
	}
}
