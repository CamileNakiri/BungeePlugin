package com.redeforest.low5tar.redeforestbungee.punish;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;
import com.redeforest.low5tar.redeforestbungee.alertbans.MySQL;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HistCommand extends Command {
	
	public HistCommand() {
		super("hist");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.punir")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /hist <usuário> para ver o histórico de usuário.");
			return;
		}
		if (args.length >= 1) {
			String nome = args[0];
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("§cConta não encontrada.");
				return;
			}
			int i = 0;
			p.sendMessage("");
			p.sendMessage("§f Histórico de " + nome + ":");
			try {
				PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome = ?");
				ps.setString(1, nome.toLowerCase());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					i++;
					String c = "§c";
					if (rs.getString("Ativo").equals("SIM")) {
						c = "§a";
					}
					String prova = " §8- §7" + rs.getString("Prova");
					if (prova.equals(" §8- §7N")) {
						prova = "";
					}
					String dataf = rs.getString("Data");
					p.sendMessage("  " + c + rs.getString("Tipo") + " §8- " + c + rs.getString("Motivo") + " §8- " + c + dataf + prova);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (i == 0) {
				p.sendMessage("§c  Sem punições no histórico.");
			}
			p.sendMessage("");
			return;
		}
	}
}
