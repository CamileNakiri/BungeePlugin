package com.redeforest.low5tar.redeforestbungee.punish;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WarnCommand extends Command {

	public WarnCommand() {
		super("warn");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender s, String[] args) {
		if (!s.hasPermission("com.redeforest.bungee.punir")) {
			s.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length < 2) {
			s.sendMessage("�cUtilize /warn <usu�rio> <motivo> para avisar um usu�rio.");
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
				if (!BungeeCord.getInstance().getPlayer(args[0]).hasPermission("com.redeforest.bungee.punir")) {
					s.sendMessage("�aVoc� alertou o usu�rio " + BungeeCord.getInstance().getPlayer(args[0]).getName() + "!");
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						all.sendMessage("");
						all.sendMessage("�c * " + args[0] + " foi avisado(a) por " + s.getName() + ".");
						all.sendMessage("�c * Motivo: " + message);
						all.sendMessage("");
					}
				} else {
					s.sendMessage("�cVoc� n�o tem permiss�o para avisar este usu�rio.");
				}
			} else {
				s.sendMessage("�cConta n�o encontrada.");
			}
			return;
		}
	}
}
