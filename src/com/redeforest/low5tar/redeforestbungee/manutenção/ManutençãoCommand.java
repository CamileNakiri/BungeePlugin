package com.redeforest.low5tar.redeforestbungee.manutenção;

import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.motd.MOTDListener;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ManutençãoCommand extends Command {
	
	public ManutençãoCommand() {
		super("manutencao");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.manutencao")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /manutencao <servidor> <on/off> para gerenciar o modo manutenção.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("info")) {
				p.sendMessage("");
				for (String s : Main.getInstance().getProxy().getServers().keySet()) {
					String cor = "§c";
					ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
					int port = i.getAddress().getPort();
					if (!ManutençãoListener.checarExiste(port)) continue;
					if (ManutençãoListener.checarOn(port)) {
						cor = "§a";
					}
					p.sendMessage("§f" + i.getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + " " + cor.replace("§a", "§a§l[§aON§l]").replace("§c", "§c§l[§cOFF§l]"));
				}
				p.sendMessage("");
				return;
			}
			sender.sendMessage("§cUtilize /manutencao <servidor> <on/off> para gerenciar o modo manutenção.");
			return;
		}
		if (args.length == 2) {
			String servidor = args[0].toLowerCase();
			if (servidor.equalsIgnoreCase("global")) {
				String toggle = args[1];
				if (toggle.equalsIgnoreCase("on")) {
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						int port = i.getAddress().getPort();
						if (!ManutençãoListener.checarExiste(port) || ManutençãoListener.checarOn(port)) continue;
						ManutençãoListener.setarOn(port);
						ManutençãoListener.findandkick(port);
					}
					MOTDListener.setarTotalManu();
					p.sendMessage("§aVocê ativou a manutenção global.");
					return;
				}
				if (toggle.equalsIgnoreCase("off")) {
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						int port = i.getAddress().getPort();
						if (!ManutençãoListener.checarExiste(port) || !ManutençãoListener.checarOn(port)) continue;
						ManutençãoListener.setarOff(port);
					}
					MOTDListener.removerTotalManu();
					p.sendMessage("§aVocê desativou a manutenção global.");
					return;
				}
				p.sendMessage("§cOpção '" + args[1] + "' inexistente.");
				return;
			}
			if (Main.getInstance().getProxy().getServers().get(servidor) == null) {
				p.sendMessage("§cServidor não encontrado.");
				return;
			}
			ServerInfo si = Main.getInstance().getProxy().getServers().get(servidor);
			int port = si.getAddress().getPort();
			if (!ManutençãoListener.checarExiste(port)) {
				p.sendMessage("§cServidor não registrado em nosso sistema.");
				return;
			}
			String toggle = args[1];
			if (toggle.equalsIgnoreCase("on")) {
				if (ManutençãoListener.checarOn(port)) {
					p.sendMessage("§cModo manutenção do servidor '" + si.getName() + "' já está ativado.");
					return;
				}
				ManutençãoListener.setarOn(port);
				ManutençãoListener.findandkick(port);
				p.sendMessage("§fModo §aMANUTENÇãO §fdo servidor '" + si.getName() + "' ativado.");
				return;
			}
			if (toggle.equalsIgnoreCase("off")) {
				if (!ManutençãoListener.checarOn(port)) {
					p.sendMessage("§cModo manutenção do servidor '" + si.getName() + "' já está desativado.");
					return;
				}
				ManutençãoListener.setarOff(port);
				p.sendMessage("§fModo §cMANUTENÇãO §fdo servidor '" + si.getName() + "' desativado.");
				return;
			}
			p.sendMessage("§cOpção '" + args[1] + "' inexistente.");
			return;
		}
		if (args.length > 2) {
			sender.sendMessage("§cUtilize /manutencao <servidor> <on/off> para gerenciar o modo manutenção.");
			return;
		}
	}
}
