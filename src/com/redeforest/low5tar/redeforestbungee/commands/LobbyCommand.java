package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LobbyCommand extends Command {
	
	public LobbyCommand() {
		super("lobby");
	}

	public static HashMap<String, Integer> conf = new HashMap<String, Integer>();

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.getServer().getInfo().getName().contains("Lobby")) {
			p.sendMessages("§cVocê está aqui.");
			return;
		}
		if (!conf.containsKey(p.getName())) {
			p.sendMessage("§eVocê tem certeza? Utilize /lobby novamente para voltar ao lobby.");
			Random r = new Random();
			int rn = r.nextInt(99999);
			conf.put(p.getName(), Integer.valueOf(rn));
			BungeeCord.getInstance().getScheduler().schedule(Main.getInstance(), new Runnable() {
				public void run() {
					if (LobbyCommand.conf.containsKey(p.getName()) && (LobbyCommand.conf.get(p.getName()).equals(Integer.valueOf(rn)))) {
						LobbyCommand.conf.remove(p.getName());
					}
				}
			}, 5L, TimeUnit.SECONDS);
			return;
		}
		conf.remove(p.getName());
		Main.getInstance().getProxy().getScheduler().schedule(Main.getInstance(), new Runnable() {
			public void run() {
				ServerInfo lobby = Main.getInstance().getProxy().getServerInfo("Lobby");
				p.connect(lobby);
			}
		}, 1L, TimeUnit.SECONDS);
	}
}
