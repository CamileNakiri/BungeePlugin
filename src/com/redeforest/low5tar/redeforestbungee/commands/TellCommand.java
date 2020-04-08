package com.redeforest.low5tar.redeforestbungee.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;
import com.redeforest.low5tar.redeforestbungee.punish.PunishAPI;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TellCommand extends Command {
	
	public static HashMap<String, Date> tello = new HashMap<String, Date>();
	public static HashMap<String, String> tell = new HashMap<String, String>();

	public TellCommand() {
		super("tell");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (PunishAPI.checkPunish(p.getName()) && PunishAPI.checkMUTE(p.getName())) {
			String data1 = PunishAPI.getDataF(p.getName());
			String data = TellCommand.getDayFormated();
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
			sender.sendMessage("§cUtilize /tell <usuário> <mensagem> para enviar uma mensagem privada.");
			return;
		}
		if (args.length == 1) {
			sender.sendMessage("§cUtilize /tell <usuário> <mensagem> para enviar uma mensagem privada.");
			return;
		}
		if (args.length > 1) {
			if (tello.containsKey(p.getName())) {
				Date now = new Date();
				if (now.after(tello.get(p.getName()))) {
					tello.remove(p.getName());
				} else {
					p.sendMessage("§cAguarde um pouco para enviar uma mensagem novamente.");
					return;
				}
			}
			if (Main.getInstance().getProxy().getPlayer(args[0]) == null) {
				p.sendMessage("§cEste usuário não está online.");
				return;
			}
			ProxiedPlayer todos = Main.getInstance().getProxy().getPlayer(args[0]);
			if (args[0].equalsIgnoreCase(p.getName())) {
				p.sendMessage("§cEvite enviar mensagens para si mesmo... Porque você não vai conhecer novas pessoas? =P");
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
			if (tell.containsKey(p.getName())) {
				tell.remove(p.getName());
			}
			if (tell.containsKey(todos.getName())) {
				tell.remove(todos.getName());
			}
			tell.put(p.getName(), todos.getName());
			tell.put(todos.getName(), p.getName());
			String message = "";
			for (String part : args) {
				if (message != "") {
					message = String.valueOf(message) + " ";
				}
				message = String.valueOf(message) + part;
			}
			int tem = args[0].length();
			p.sendMessage("§8[Mensagem para §7" + todos.getName() + "§8]:§6" + message.substring(tem));
			todos.sendMessage("§8[Mensagem de §7" + p.getName() + "§8]:§6" + message.substring(tem));
			if (tello.containsKey(p.getName())) {
				tello.remove(p.getName());
			}
			Date na = new Date();
			na.setSeconds(na.getSeconds() + 3);
			tello.put(p.getName(), na);
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
