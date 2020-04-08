package com.redeforest.low5tar.redeforestbungee.punish;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.alertbans.MySQL;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PunishAPI {

	public static boolean checkBanin(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ? AND Tipo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ps.setString(3, "BAN");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkMutin(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ? AND Tipo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ps.setString(3, "MUTE");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkPunish(String nome) {
		try {
			try {
				PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
				ps.setString(1, nome.toLowerCase());
				ps.setString(2, "SIM");
				ResultSet rs = ps.executeQuery();
				if (!rs.next())
					return false;
				return true;
			} catch (NullPointerException ex) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkBAN(String nome) {
		String tipo = getTipo(nome);
		return tipo.equals("BAN");
	}

	public static boolean checkMUTE(String nome) {
		String tipo = getTipo(nome);
		return tipo.equals("MUTE");
	}

	public static boolean taAtivo(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=?");
			ps.setString(1, nome.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if (rs.next() && (rs.getString("Ativo")).equals("SIM")) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean temFim(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next() && (rs.getString("Fim")).equals("SIM")) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean temProva(String nome) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next() && !(rs.getString("Prova")).equals("N")) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public static String getData(String nome) {
        String data = "";
        try {
            PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
            ps.setString(1, nome.toLowerCase());
            ps.setString(2, "SIM");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data = rs.getString("Data");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

	public static String getTipo(String nome) {
		String tipo = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tipo = rs.getString("Tipo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo;
	}

	public static String getAutor(String nome) {
		String autor = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				autor = rs.getString("Autor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autor;
	}

	public static String getDataF(String nome) {
		String dataf = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dataf = rs.getString("DataF");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataf;
	}

	public static String getProva(String nome) {
		String prova = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				prova = rs.getString("Prova");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prova;
	}

	public static String getMotivoMUTE(String nome) {
		String motivo = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ? AND Tipo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ps.setString(3, "MUTE");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				motivo = rs.getString("Motivo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motivo;
	}

	public static String getMotivoBAN(String nome) {
		String motivo = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ? AND Tipo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ps.setString(3, "BAN");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				motivo = rs.getString("Motivo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motivo;
	}

	public static String getMotivo(String nome) {
		String motivo = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				motivo = rs.getString("Motivo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motivo;
	}

	public static String getNick(String nome) {
		String nick = "";
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nick = rs.getString("Nick");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nick;
	}

	public static Integer getID(String nome) {
		int id = 0;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish WHERE Nome=? AND Ativo = ?");
			ps.setString(1, nome.toLowerCase());
			ps.setString(2, "SIM");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
    @SuppressWarnings("deprecation")
	public static String getDateF(int dias, int horas, int minutos) {
        @SuppressWarnings("unused")
		int hora;
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        int dps = hora = now.getHours();
        now.setHours(dps);
        int d = now.getDate();
        int dd = d + dias;
        int h = now.getHours();
        int hd = h + horas;
        int m = now.getMinutes();
        int md = m + minutos;
        now.setDate(dd);
        now.setHours(hd);
        now.setMinutes(md);
        String data = format.format(now);
        return data;
    }

	@SuppressWarnings("deprecation")
	public static void punirJogador(String nome, CommandSender px, String tipo, String prova, String motivo, String data, int dias, int horas, int minutos) {
		if (tipo.equals("MUTE") && checkMutin(nome)) {
			px.sendMessage("§cEste usuário já está mutado por '" + getMotivoMUTE(nome) + "'.");
			return;
		}
		if (tipo.equals("BAN") && checkBanin(nome)) {
			px.sendMessage("§cEste usuário já está punido por '" + getMotivoBAN(nome) + "'.");
			return;
		}
		String autor = px.getName();
		String fim = "NAO";
		String dataf = "N";
		int check = dias + horas + minutos;
		if (check > 0) {
			fim = "SIM";
			dataf = getDateF(dias, horas, minutos);
		}
		int id = getLastID() + 1;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO Punish (ID,Nome,Nick,Tipo,Motivo,Autor,Prova,Data,Fim,DataF,Ativo) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, id);
			ps.setString(2, nome.toLowerCase());
			ps.setString(3, nome);
			ps.setString(4, tipo);
			ps.setString(5, motivo);
			ps.setString(6, autor);
			ps.setString(7, prova);
			ps.setString(8, data);
			ps.setString(9, fim);
			ps.setString(10, dataf);
			ps.setString(11, "SIM");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("MutePunish");
		out.writeUTF("Toque");
		if (Main.getInstance().getProxy().getPlayer(nome) != null) {
			Main.getInstance().getProxy().getPlayer(nome).getServer().sendData("MutePunish", out.toByteArray());
		}
		findandkick(nome, tipo);
		if (prova.equals("N")) {
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
				for (ProxiedPlayer todos : i.getPlayers()) {
					todos.sendMessage("");
					todos.sendMessage(" §c* " + nome + " foi " + tipo.replace("MUTE", "mutado").replace("BAN", "punido") + " por " + autor + ".");
					todos.sendMessage(" §c* Motivo: " + motivo);
					todos.sendMessage("");
				}
			}
			return;
		}
		for (String s : Main.getInstance().getProxy().getServers().keySet()) {
			ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
			for (ProxiedPlayer todos : i.getPlayers()) {
				todos.sendMessage("");
				todos.sendMessage(" §c* " + nome + " foi " + tipo.replace("MUTE", "mutado").replace("BAN", "punido") + " por " + autor + ".");
				todos.sendMessage(" §c* Motivo: " + motivo + " - " + prova);
				todos.sendMessage("");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void punirJogadorS(String nome, String autor, String tipo, String prova, String motivo, String data, int dias, int horas, int minutos) {
		String fim = "NAO";
		String dataf = "N";
		int check = dias + horas + minutos;
		if (check > 0) {
			fim = "SIM";
			dataf = getDateF(dias, horas, minutos);
		}
		int id = getLastID() + 1;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("INSERT INTO Punish (ID,Nome,Nick,Tipo,Motivo,Autor,Prova,Data,Fim,DataF,Ativo) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, id);
			ps.setString(2, nome.toLowerCase());
			ps.setString(3, nome);
			ps.setString(4, tipo);
			ps.setString(5, motivo);
			ps.setString(6, autor);
			ps.setString(7, prova);
			ps.setString(8, data);
			ps.setString(9, fim);
			ps.setString(10, dataf);
			ps.setString(11, "SIM");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("MutePunish");
		out.writeUTF("Toque");
		if (Main.getInstance().getProxy().getPlayer(nome) != null) {
			Main.getInstance().getProxy().getPlayer(nome).getServer().sendData("MutePunish", out.toByteArray());
		}
		findandkick(nome, tipo);
		if (prova.equals("N")) {
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
				for (ProxiedPlayer todos : i.getPlayers()) {
					if (!todos.hasPermission("whyze.punir")) continue;
					todos.sendMessage("");
					todos.sendMessage(" §c* " + nome + " foi " + tipo.replace("MUTE", "mutado").replace("BAN", "punido") + " por " + autor + ".");
					todos.sendMessage(" §c* Motivo: " + motivo);
					todos.sendMessage("");
				}
			}
			return;
		}
		for (String s : Main.getInstance().getProxy().getServers().keySet()) {
			ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
			for (ProxiedPlayer todos : i.getPlayers()) {
				if (!todos.hasPermission("whyze.punir")) continue;
				todos.sendMessage("");
				todos.sendMessage(" §c* " + nome + " foi " + tipo.replace("MUTE", "mutado").replace("BAN", "punido") + " por " + autor + ".");
				todos.sendMessage(" §c* Motivo: " + motivo + " - " + prova);
				todos.sendMessage("");
			}
		}
	}

	public static int getLastID() {
		int last = 0;
		int i = 0;
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM Punish ORDER BY Punish.ID DESC;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				if (i != 1) {
					i++;
					last = id;
				}
			}
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
		return last;
	}

	public static void despunirJogador(String nome, int id) {
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("UPDATE Punish SET Ativo = ? WHERE ID = ?;");
			ps.setString(1, "NAO");
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("MutePunish");
		out.writeUTF("Toque");
		if (Main.getInstance().getProxy().getPlayer(nome) != null) {
			Main.getInstance().getProxy().getPlayer(nome).getServer().sendData("MutePunish", out.toByteArray());
		}
	}

	@SuppressWarnings("deprecation")
	public static void findandkick(String nome, String tipo) {
		if (tipo.equals("BAN") && Main.getInstance().getProxy().getPlayer(nome) != null) {
			ProxiedPlayer p = Main.getInstance().getProxy().getPlayer(nome);
			p.disconnect("§c§lREDE WHYZE\n§1\n§cVocê foi punido do servidor.");
		}
		tipo.equals("MUTE");
	}
}
