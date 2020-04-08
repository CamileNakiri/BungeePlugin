package com.redeforest.low5tar.redeforestbungee.manuten��o;

import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.motd.MOTDListener;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Manuten��oCommand extends Command {
	
	public Manuten��oCommand() {
		super("manutencao");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.manutencao")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /manutencao <servidor> <on/off> para gerenciar o modo manuten��o.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("info")) {
				p.sendMessage("");
				for (String s : Main.getInstance().getProxy().getServers().keySet()) {
					String cor = "�c";
					ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
					int port = i.getAddress().getPort();
					if (!Manuten��oListener.checarExiste(port)) continue;
					if (Manuten��oListener.checarOn(port)) {
						cor = "�a";
					}
					p.sendMessage("�f" + i.getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + " " + cor.replace("�a", "�a�l[�aON�l]").replace("�c", "�c�l[�cOFF�l]"));
				}
				p.sendMessage("");
				return;
			}
			sender.sendMessage("�cUtilize /manutencao <servidor> <on/off> para gerenciar o modo manuten��o.");
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
						if (!Manuten��oListener.checarExiste(port) || Manuten��oListener.checarOn(port)) continue;
						Manuten��oListener.setarOn(port);
						Manuten��oListener.findandkick(port);
					}
					MOTDListener.setarTotalManu();
					p.sendMessage("�aVoc� ativou a manuten��o global.");
					return;
				}
				if (toggle.equalsIgnoreCase("off")) {
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						int port = i.getAddress().getPort();
						if (!Manuten��oListener.checarExiste(port) || !Manuten��oListener.checarOn(port)) continue;
						Manuten��oListener.setarOff(port);
					}
					MOTDListener.removerTotalManu();
					p.sendMessage("�aVoc� desativou a manuten��o global.");
					return;
				}
				p.sendMessage("�cOp��o '" + args[1] + "' inexistente.");
				return;
			}
			if (Main.getInstance().getProxy().getServers().get(servidor) == null) {
				p.sendMessage("�cServidor n�o encontrado.");
				return;
			}
			ServerInfo si = Main.getInstance().getProxy().getServers().get(servidor);
			int port = si.getAddress().getPort();
			if (!Manuten��oListener.checarExiste(port)) {
				p.sendMessage("�cServidor n�o registrado em nosso sistema.");
				return;
			}
			String toggle = args[1];
			if (toggle.equalsIgnoreCase("on")) {
				if (Manuten��oListener.checarOn(port)) {
					p.sendMessage("�cModo manuten��o do servidor '" + si.getName() + "' j� est� ativado.");
					return;
				}
				Manuten��oListener.setarOn(port);
				Manuten��oListener.findandkick(port);
				p.sendMessage("�fModo �aMANUTEN��O �fdo servidor '" + si.getName() + "' ativado.");
				return;
			}
			if (toggle.equalsIgnoreCase("off")) {
				if (!Manuten��oListener.checarOn(port)) {
					p.sendMessage("�cModo manuten��o do servidor '" + si.getName() + "' j� est� desativado.");
					return;
				}
				Manuten��oListener.setarOff(port);
				p.sendMessage("�fModo �cMANUTEN��O �fdo servidor '" + si.getName() + "' desativado.");
				return;
			}
			p.sendMessage("�cOp��o '" + args[1] + "' inexistente.");
			return;
		}
		if (args.length > 2) {
			sender.sendMessage("�cUtilize /manutencao <servidor> <on/off> para gerenciar o modo manuten��o.");
			return;
		}
	}
}
