package com.redeforest.low5tar.redeforestbungee.punish;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class PunirCommand extends Command {
	
	public PunirCommand() {
		super("punir", "com.redeforest.bungee.punir", "ban", "punish");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender p, String[] args) {
		if (!p.hasPermission("com.redeforest.bungee.punir")) {
			p.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("�cUtilize /punir <usu�rio> para exibir os tipos de infra��es.");
			return;
		}
		if (args.length == 1) {
			String nome = args[0];
			if (nome.equalsIgnoreCase("asgydyuga")) {
				p.sendMessage("�cVoc� n�o tem permiss�o para punir este usu�rio.");
				return;
			}
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("�cConta n�o encontrada.");
				return;
			}
			if (PunishAPI.checkBanin(nome)) {
				p.sendMessage("�cUsu�rio j� punido por '" + PunishAPI.getMotivoBAN(nome) + "'.");
				return;
			}
			PunirAPI.mandarPlayer(p, nome, false);
			return;
		}
		if (args.length == 2) {
			String nome = args[0];
			if (nome.equalsIgnoreCase("asgydyuga")) {
				p.sendMessage("�cVoc� n�o tem permiss�o para punir este usu�rio.");
				return;
			}
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("�cConta n�o encontrada.");
				return;
			}
			if (PunishAPI.checkBanin(nome)) {
				p.sendMessage("�cUsu�rio j� punido por '" + PunishAPI.getMotivoBAN(nome) + "'.");
				return;
			}
			String motivo = args[1];
			if (motivo.equalsIgnoreCase("desconhecido")) {
				if (!p.hasPermission("com.redeforest.bungee.staff")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Desconhecido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("abusodebugs")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Abuso de Bugs";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("antijogo")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Antijogo";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 1, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("caps-lock")) {
				motivo = "Caps-Lock";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 2, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("contafake")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Conta fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("modn�opermitido")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Mod n�o permitido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulga��ograve")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Divulga��o grave";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("desinforma��o")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Desinforma��o";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulga��osimples")) {
				motivo = "Divulga��o simples";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("flood")) {
				motivo = "Flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("spam")) {
				motivo = "SPAM";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hack")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Uso de Hack";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadebriga")) {
				motivo = "Iniciativa de briga";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadeflood")) {
				motivo = "Iniciativa de flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("chatfake")) {
				motivo = "Chat fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("nicknameinapropriado")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Nickname inapropriado";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensa�usu�rio")) {
				motivo = "Ofensa � usu�rio";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensa�staff/servidor")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Ofensa � staff/servidor";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("palavrasinadequadas")) {
				motivo = "Palavras inadequadas";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hashtag")) {
				motivo = "Uso de HashTag";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("enganar�staff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Enganar � staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("Deslogar/negarpedidodetela")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Deslogar/negar pedido de tela";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("modn�opermitido(pc)")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Mod n�o permitido (PC)";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 3, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("amea�a�staff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Amea�a � staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("amea�a�usu�rio")) {
				motivo = "Amea�a � usu�rio";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			p.sendMessage("�cMotivo inv�lido.");
			return;
		}
		if (args.length == 3) {
			String nome = args[0];
			if (nome.equalsIgnoreCase("ygsaygsagy")) {
				p.sendMessage("�cVoc� n�o tem permiss�o para punir este usu�rio.");
				return;
			}
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("�cConta n�o encontrada.");
				return;
			}
			if (PunishAPI.checkPunish(nome)) {
				if (PunishAPI.checkBAN(nome)) {
					p.sendMessage("�cEste usu�rio j� punido por '" + PunishAPI.getMotivo(nome) + "'.");
					return;
				}
			}
			String motivo = args[1];

			String prova = args[2];
			if (motivo.equalsIgnoreCase("modn�opermitido")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Mod n�o permitido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("desconhecido")) {
				if (!p.hasPermission("com.redeforest.bungee.admin")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Desconhecido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("abusodebugs")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Abuso de Bugs";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("antijogo")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Antijogo";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 1, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("caps-lock")) {
				motivo = "Caps-Lock";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 2, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("caps-lock")) {
				motivo = "Caps-Lock";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 1, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("contafake")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Conta fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("desinforma��o")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Desinforma��o";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulga��ograve")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Divulga��o grave";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulga��osimples")) {
				motivo = "Divulga��o simples";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("flood")) {
				motivo = "Flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("spam")) {
				motivo = "SPAM";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hack")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Uso de Hack";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadebriga")) {
				motivo = "Iniciativa de briga";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadeflood")) {
				motivo = "Iniciativa de flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("chatfake")) {
				motivo = "Chat fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("nicknameinapropriado")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Nickname inapropriado";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensa�usu�rio")) {
				motivo = "Ofensa � usu�rio";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensa�staff/servidor")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Ofensa � staff/servidor";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("palavrasinadequadas")) {
				motivo = "Palavras inadequadas";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hashtag")) {
				motivo = "Uso de HashTag";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("enganar�staff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Enganar � staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("Deslogar/negarpedidodetela")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Deslogar/negar pedido de tela";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("modn�opermitido(pc)")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Mod n�o permitido (PC)";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 3, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("amea�a�staff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para punir por este motivo.");
					return;
				}
				motivo = "Amea�a � staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("amea�a�usu�rio")) {
				motivo = "Amea�a � usu�rio";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogador(nick, p, "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			p.sendMessage("�cMotivo inv�lido.");
			return;
		}
		if (args.length > 2) {
			p.sendMessage("�cUtilize /punir <usu�rio> para exibir os tipos de infra��es.");
			return;
		}
	}

	@SuppressWarnings("deprecation")
	public static String getDayFormated() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		int hora = now.getHours();
		int dps = hora;
		now.setHours(dps);
		String data = format.format(now);
		return data;
	}
}
