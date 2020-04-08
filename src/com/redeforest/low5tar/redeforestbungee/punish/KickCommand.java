package com.redeforest.low5tar.redeforestbungee.punish;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class KickCommand extends Command {

	public KickCommand() {
		super("kick");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender s, String[] args) {
		if (!s.hasPermission("com.redeforest.bungee.punir")) {
			s.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length < 2) {
			s.sendMessage("§cUtilize /kick <usuário> <motivo> para kickar um usuário.");
			return;
		}
		if (args.length > 0) {
			StringBuilder string = new StringBuilder();
			for (int i = 1; i < args.length; i++) {
				if (args.length > 2) {
					string.append(args[i] + " ");
				} else {
					string.append(args[i]);
				}
			}
			String message = string.toString();
			if (BungeeCord.getInstance().getPlayer(args[0]) != null) {
				if (!BungeeCord.getInstance().getPlayer(args[0]).hasPermission("com.redeforest.bungee.admin")) {
					s.sendMessage("§aVocê expulsou o usuário " + BungeeCord.getInstance().getPlayer(args[0]).getName() + "!");
					BungeeCord.getInstance().getPlayer(args[0]).disconnect("§c§lREDE FOREST\n§c\n§cVocê foi kickado pelo usuário '" + s.getName() + "'." + "\n\n" + "§cMotivo: " + message);
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						all.sendMessage("");
						all.sendMessage("§c * " + args[0] + " foi kickado(a) por " + s.getName() + ".");
						all.sendMessage("§c * Motivo: " + message);
						all.sendMessage("");
					}
				} else {
					s.sendMessage("§cVocê não tem permissão para kickar este usuário.");
				}
			} else {
				s.sendMessage("§cConta não encontrada.");
			}
			return;
		}
	}
}
