package com.redeforest.low5tar.redeforestbungee.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;
import com.redeforest.low5tar.redeforestbungee.punish.PunishAPI;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RCommand extends Command {
	
	public RCommand() {
		super("r");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (PunishAPI.checkPunish(p.getName()) && PunishAPI.checkMUTE(p.getName())) {
			String data1 = PunishAPI.getDataF(p.getName());
			String data = RCommand.getDayFormated();
			int part1 = Integer.valueOf(data1.split(" ")[0].replace("/", ""));
			int partn = Integer.valueOf(data.split(" ")[0].replace("/", ""));
			if (partn < part1) {
				String autor = PunishAPI.getAutor(p.getName());
				String motivo = PunishAPI.getMotivo(p.getName());
				if (PunishAPI.temProva(p.getName())) {
					String prova = PunishAPI.getProva(p.getName());
					motivo = String.valueOf(motivo) + " - " + prova;
				}
				p.sendMessage("");
				p.sendMessage("§c Você está mutado, poderá utilizar o chat novamente em " + data1.replace(" ", " às ") + ".");
				p.sendMessage("");
				p.sendMessage("§c Autor: " + autor);
				p.sendMessage("§c Motivo: " + motivo);
				p.sendMessage("");
				return;
			}
			if (partn > part1) {
				int id = PunishAPI.getID(p.getName());
				PunishAPI.despunirJogador(p.getName(), id);
			}
			if (partn == part1) {
				int part12 = Integer.valueOf(data1.split(" ")[1].replace(":", ""));
				int partn2 = Integer.valueOf(data.split(" ")[1].replace(":", ""));
				if (partn2 >= part12) {
					int id = PunishAPI.getID(p.getName());
					PunishAPI.despunirJogador(p.getName(), id);
				}
				if (partn2 < part12) {
					String autor = PunishAPI.getAutor(p.getName());
					String motivo = PunishAPI.getMotivo(p.getName());
					if (PunishAPI.temProva(p.getName())) {
						String prova = PunishAPI.getProva(p.getName());
						motivo = String.valueOf(motivo) + " - " + prova;
					}
					p.sendMessage("");
					p.sendMessage("§c Você está mutado, poderá utilizar o chat novamente em " + data1.replace(" ", " às ") + ".");
					p.sendMessage("");
					p.sendMessage("§c Autor: " + autor);
					p.sendMessage("§c Motivo: " + motivo);
					p.sendMessage("");
					return;
				}
			}
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /r <mensagem> para enviar uma mensagem privada.");
			return;
		}
		if (args.length > 0) {
			if (TellCommand.tello.containsKey(p.getName())) {
				Date now = new Date();
				if (now.after(TellCommand.tello.get(p.getName()))) {
					TellCommand.tello.remove(p.getName());
				} else {
					p.sendMessage("§cAguarde um pouco para enviar uma mensagem novamente.");
					return;
				}
			}
			if (TellCommand.tell.get(p.getName()) == null) {
				p.sendMessage("§cVocê não tem uma conversa recente.");
				return;
			}
			String nome = TellCommand.tell.get(p.getName());
			if (Main.getInstance().getProxy().getPlayer(nome) == null) {
				p.sendMessage("§cEste usuário não está on-line.");
				return;
			}
			ProxiedPlayer todos = Main.getInstance().getProxy().getPlayer(nome);
			if (args[0].equalsIgnoreCase(p.getName())) {
				p.sendMessage("§cEvite enviar mensagens para si mesmo, porque você não vai conhecer novas pessoas? =P");
				return;
			}
			if (!p.hasPermission("com.redeforest.bungee.equipe")) {
				if (Manager.checarPrefs(todos.getName(), "VANISH")) {
					sender.sendMessage("§cEste usuário não está online.");
					return;
				}
				if (Manager.checarPrefs(todos.getName(), "TELL")) {
					p.sendMessage("§cEste usuário desativou o recebimento de mensagens privadas.");
					return;
				}
			}
			if (todos.hasPermission("com.redeforest.bungee.master")) {
				if (Manager.checarPrefs(todos.getName(), "VANISH")) {
					sender.sendMessage("§cEste usuário não está online.");
					return;
				}
				if (Manager.checarPrefs(todos.getName(), "TELL")) {
					p.sendMessage("§cEste usuário desativou o recebimento de mensagens privadas.");
					return;
				}
			}
			String message = "";
			for (String part : args) {
				if (message != "") {
					message = String.valueOf(message) + " ";
				}
				message = String.valueOf(message) + part;
			}
			p.sendMessage("§8[Mensagem para §7" + todos.getName() + "§8]: §6" + message);
			todos.sendMessage("§8[Mensagem de §7" + p.getName() + "§8]: §6" + message);
			if (TellCommand.tello.containsKey(p.getName())) {
				TellCommand.tello.remove(p.getName());
			}
			Date na = new Date();
			na.setSeconds(na.getSeconds() + 3);
			TellCommand.tello.put(p.getName(), na);
		}
	}

	@SuppressWarnings("deprecation")
	public static String getDayFormated() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		int hora = now.getHours();
		int dps = hora + 1;
		now.setHours(dps);
		String data = format.format(now);
		return data;
	}
}
