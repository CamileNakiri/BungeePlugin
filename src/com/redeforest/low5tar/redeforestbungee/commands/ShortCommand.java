package com.redeforest.low5tar.redeforestbungee.commands;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.redeforest.low5tar.redeforestbungee.alertbans.MySQL;
import com.redeforest.low5tar.redeforestbungee.utils.RandomString;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ShortCommand extends Command {

	public ShortCommand() {
		super("short");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.short")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("§cUtilize /short <link>.");
			return;
		}
		if (args.length == 1) {
			String url = args[0];
			String sho = "";
			int length = 5;
			int ch = 0;
			if (args[0].contains("https://")) {
				ch++;
			}
			if (args[0].contains("http://")) {
				ch++;
			}
			if (ch == 0) {
				p.sendMessage("§cA url deve conter 'https://' ou 'http://'.");
				return;
			}
			RandomString rs = new RandomString(length);
			sho = rs.nextString();
			p.sendMessage("§eCarregando...");
			try {
				insertShort(sho, url);
				p.sendMessage("§aUrl encurtada com sucesso para §e§nhttp://forest.me/" + sho);
			} catch (SQLException e) {
				p.sendMessage("§cNão foi possível encurtar esta url. Tente novamente mais tarde.");

				e.printStackTrace();
			}
			return;
		}
		if (args.length > 1) {
			p.sendMessage("§cUtilize /short <link>.");
			return;
		}
	}

	public static void insertShort(String sho, String url) throws SQLException {
		int id = getLastID();
		PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO website_shortener (shortener_ID,shortener_HASH,shortener_REDIRECT,shortener_CLICKS) VALUES (?,?,?,?);");
		ps.setInt(1, id);
		ps.setString(2, sho);
		ps.setString(3, url);
		ps.setInt(4, 0);
		ps.executeUpdate();
	}

	public static int getLastID() {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM website_shortener ORDER BY website_shortener.shortener_ID DESC;");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("shortener_ID") + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
