package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class OnlineCommand extends Command {
	
	public OnlineCommand() {
		super("online");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.hasPermission("com.redeforest.bungee.master") || p.hasPermission("com.redeforest.bungee.gerente")) {
			int total = 0;
			int thi = 0;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
				total += i.getPlayers().size();
				if (!i.getName().equalsIgnoreCase(p.getServer().getInfo().getName())) continue;
				thi += i.getPlayers().size();
			}
			p.sendMessages("");
			p.sendMessages(" §6" + total + " §eusuários online em toda a rede.");
			p.sendMessages(" §6" + thi + " §eusuários online neste servidor.");
			p.sendMessages("");
			int ch = 0;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
				p.sendMessage("§e * §6" + i.getPlayers().size() + " §eonline no " + i.getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup));
				++ch;
			}
			if (ch > 0) {
				p.sendMessage("");
			}
		} else {
			int total = 0;
			int thi = 0;
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
				total += i.getPlayers().size();
				if (!i.getName().equalsIgnoreCase(p.getServer().getInfo().getName()))
					continue;
				thi += i.getPlayers().size();
			}
			p.sendMessages("");
			p.sendMessages(" §6" + total + " §eusuários online em toda a rede.");
			p.sendMessages(" §6" + thi + " §eusuários online neste servidor.");
			p.sendMessages("");
		}
	}
}
