package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.utils.Address;

import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfoCommand extends Command {

	public InfoCommand() {
		super("inf");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("com.redeforest.bungee.whois")) {
			if (args.length == 0) {
				sender.sendMessage("§cUtilize /inf <usuário>.");
				return;
			} else if (args.length == 1) {
				ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);
				if (p == null) {
					sender.sendMessage("§cEste usuário não está on-line.");
					return;
				}
				sender.sendMessage("");
				sender.sendMessage(" §fUsuário: §7" + p.getName());
				sender.sendMessage(" §fIP: §7" + p.getAddress().getAddress().getHostAddress());
				sender.sendMessage(" §fCargo: §7" + BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).buildPrefix().replace("&", "§"));
				sender.sendMessage(" §fPing: §7" + p.getPing() + "ms");
				if (sender.hasPermission("whyze.gerente")) {
					sender.sendMessage(" §fIP conectado: §7" + Address.getAddres(p));
				}
				sender.sendMessage(" §fServidor conectado: §7" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup));
				sender.sendMessage("");
				return;
			}
		} else {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
	}
	
}
