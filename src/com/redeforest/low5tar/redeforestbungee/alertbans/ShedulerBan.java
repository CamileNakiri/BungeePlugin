package com.redeforest.low5tar.redeforestbungee.alertbans;

import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;
import java.util.concurrent.*;

import com.redeforest.low5tar.redeforestbungee.Main;

import java.text.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class ShedulerBan {
	
	public static NumberFormat numberFormat;

	public static void iniciarSheduler() {
		Main.getInstance().getProxy().getScheduler().schedule(Main.getInstance(), new Runnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				int total = ShedulerBan.getBansDay2();
				if (total == 0) {
					for (String s : Main.getInstance().getProxy().getServers().keySet()) {
						ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
						for (ProxiedPlayer todos : i.getPlayers()) {
							todos.sendMessage("");
							todos.sendMessage("§e * Total de punições do servidor: §d" + ShedulerBan.format(ShedulerBan.getTotalBans()).replace(" ", "") + "§e.");
							todos.sendMessage("§e * Nenhum usuário foi punido hoje, dia §d" + ShedulerBan.getDayFormated() + "§e.");
							todos.sendMessage("");
						}
					}
					return;
				}
				String joga = "usuários";
				if (total == 1) {
					joga = "usuário";
				}
				for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
					ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
					for (ProxiedPlayer todos2 : j.getPlayers()) {
						todos2.sendMessage("");
						todos2.sendMessage("§e * Foram punidos §d" + ShedulerBan.format(total).replace(" ", "") + " §e" + joga + " hoje, dia §d" + ShedulerBan.getDayFormated() + "§e.");
						todos2.sendMessage("§e * Total de punições do servidor: §d" + ShedulerBan.format(ShedulerBan.getTotalBans()).replace(" ", "") + "§e.");
						todos2.sendMessage("§e * Utilize §d/reportar §ee ajude-nos nesse combate.");
						todos2.sendMessage("");
					}
				}
			}
		}, 10, 10, TimeUnit.MINUTES);
	}

	@SuppressWarnings("deprecation")
	public static String getDayFormated() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		int hora = now.getHours();
		int dps = hora + 1;
		now.setHours(dps);
		String data = format.format(now);
		return data;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public static Integer getBansDay2() {
		String formatado;
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		int hora = now.getHours();
		int dps = hora + 1;
		now.setHours(dps);
		String daten = formatado = format.format(now);
		int i = 0;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String datacru = rs.getString("Data");
				String data = datacru.split(" ")[0];
				if (!data.equals(daten))
					continue;
				++i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static Integer getTotalBans() {
		int i = 0;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				++i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static String format(double value) {
		numberFormat = NumberFormat.getNumberInstance(Locale.forLanguageTag("en-US"));
		if (value <= 1.0) {
			return numberFormat.format(value).concat(" ").concat("");
		}
		return numberFormat.format(value).concat(" ").concat("").replace(",", ".").replace(" ", "");
	}
}

