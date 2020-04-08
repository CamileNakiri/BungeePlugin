package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.utils.TitleAPI;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AlertaCommand extends Command {

	public AlertaCommand() {
		super("alerta", "", "anuncio");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("com.redeforest.bungee.alert")) {
			if (args.length < 2) {
				sender.sendMessage("§cUtilize /alerta <chat/title> [mensagem] para enviar um alerta para todos os usuários.");
				return;
			} else if (args.length > 1) {
				String message = "";
				for (int i = 1; i < args.length; i++) {
					message = message + args[i] + " ";
				}
				if (args[0].equalsIgnoreCase("chat")) {
					ProxyServer.getInstance().broadcast();
					if (sender instanceof ProxiedPlayer) {
						ProxyServer.getInstance().broadcast("");
						ProxyServer.getInstance().broadcast(message.replace("&", "§"));
						ProxyServer.getInstance().broadcast("");
					} else {
						ProxyServer.getInstance().broadcast("");
						ProxyServer.getInstance().broadcast(" §d§l[ANÚNCIO] §f" + message.replace("&", "§"));
						ProxyServer.getInstance().broadcast("");
					}
					ProxyServer.getInstance().broadcast();
				} else if (args[0].equalsIgnoreCase("title")) {
					String title = message.replace("&", "§");
					if (message.contains("<nl>")) {
						title = message.split("<nl>")[0];
						String subtitle = message.split("<nl>")[1];
						for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
							TitleAPI.sendTitle(on, title, subtitle);
						}
					} else {
						for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
							TitleAPI.sendTitle(on, title, "");
						}
					}
				}
			}
		} else {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
	}
}

