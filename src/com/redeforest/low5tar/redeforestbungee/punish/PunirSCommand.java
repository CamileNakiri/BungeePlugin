package com.redeforest.low5tar.redeforestbungee.punish;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class PunirSCommand extends Command {
	
	public PunirSCommand() {
		super("punirs");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender p, String[] args) {
		if (!p.hasPermission("com.redeforest.bungee.punir")) {
			p.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("§cUtilize /punirs <usuário> para exibir os tipos de infrações.");
			return;
		}
		if (args.length == 1) {
			String nome = args[0];
			if (nome.equalsIgnoreCase("ysgauygsayugas")) {
				p.sendMessage("§cVocê não tem permissão para punir este usuário.");
				return;
			}
			if (nome.equalsIgnoreCase("ygasuygasugy")) {
				p.sendMessage("§cVocê não tem permissão para punir este usuário.");
				return;
			}
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("§cConta não encontrada.");

				return;
			}
			if (PunishAPI.checkPunish(nome)) {
				if (PunishAPI.checkBAN(nome)) {
					p.sendMessage("§cUsuário já punido por '" + PunishAPI.getMotivo(nome) + "'.");
					return;
				}
			}
			PunirAPI.mandarPlayer(p, nome, true);
			return;
		}
		if (args.length == 2) {
			String nome = args[0];
			if (nome.equalsIgnoreCase("yugasyugsayugas")) {
				p.sendMessage("§cVocê não tem permissão para punir este usuário.");
				return;
			}
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("§cConta não encontrada.");
				return;
			}
			if (PunishAPI.checkPunish(nome)) {
				if (PunishAPI.checkBAN(nome)) {
					p.sendMessage("§cUsuário já punido por '" + PunishAPI.getMotivo(nome) + "'.");
					return;
				}
			}
			String motivo = args[1];
			if (motivo.equalsIgnoreCase("desconhecido")) {
				if (!p.hasPermission("com.redeforest.bungee.")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Desconhecido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("abusodebugs")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Abuso de Bugs";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("antijogo")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Antijogo";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 1, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("caps-lock")) {
				motivo = "Caps-Lock";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 2, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("contafake")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Conta fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("modnãopermitido")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Mod não permitido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulgaçãograve")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Divulgação grave";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("desinformação")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Desinformação";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulgaçãosimples")) {
				motivo = "Divulgação simples";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("flood")) {
				motivo = "Flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("spam")) {
				motivo = "SPAM";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hack")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Uso de Hack";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadebriga")) {
				motivo = "Iniciativa de briga";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadeflood")) {
				motivo = "Iniciativa de flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("chatfake")) {
				motivo = "Chat fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("nicknameinapropriado")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Nickname inapropriado";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensaàjogador")) {
				motivo = "Ofensa à usuário";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensaàstaff/servidor")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Ofensa à staff/servidor";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("palavrasinadequadas")) {
				motivo = "Palavras inadequadas";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hashtag")) {
				motivo = "Uso de HashTag";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("enganaràstaff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Enganar à staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("Deslogar/negarpedidodetela")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Deslogar/negar pedido de tela";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("modnãopermitido(pc)")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Mod não permitido (PC)";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 3, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ameaçaàstaff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Ameaça à staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", "N", motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ameaçaàjogador")) {
				motivo = "Ameaça à usuário";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", "N", motivo, data, 0, 5, 0);
				return;
			}
			p.sendMessage("§cMotivo inválido.");
			return;
		}
		if (args.length == 3) {
			String nome = args[0];
			if (nome.equalsIgnoreCase("uashisz")) {
				p.sendMessage("§cVocê tem permissão para punir este usuário.");
				return;
			}
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("§cConta não encontrada.");
				return;
			}
			if (PunishAPI.checkPunish(nome)) {
				if (PunishAPI.checkBAN(nome)) {
					p.sendMessage("§cEste usuário já punido por '" + PunishAPI.getMotivo(nome) + "'.");
					return;
				}
			}
			String motivo = args[1];
			String prova = args[2];
			if (motivo.equalsIgnoreCase("modnãopermitido")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Mod não permitido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("desconhecido")) {
				if (!p.hasPermission("com.redeforest.bungee.admin")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Desconhecido";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("abusodebugs")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Abuso de Bugs";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("antijogo")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Antijogo";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 1, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("caps-lock")) {
				motivo = "Caps-Lock";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 2, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("contafake")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Conta fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("desinformação")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Desinformação";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulgaçãograve")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Divulgação grave";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("divulgaçãosimples")) {
				motivo = "Divulgação simples";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("flood")) {
				motivo = "Flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("spam")) {
				motivo = "SPAM";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 4, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hack")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Uso de Hack";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadebriga")) {
				motivo = "Iniciativa de briga";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("iniciativadeflood")) {
				motivo = "Iniciativa de flood";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("chatfake")) {
				motivo = "Chat fake";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("nicknameinapropriado")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Nickname inapropriado";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensaàjogador")) {
				motivo = "Ofensa à usuário";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 6, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ofensaàstaff/servidor")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Ofensa à staff/servidor";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("palavrasinadequadas")) {
				motivo = "Palavras inadequadas";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("hashtag")) {
				motivo = "Uso de HashTag";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("enganaràstaff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Enganar à staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("Deslogar/negarpedidodetela")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Deslogar/negar pedido de tela";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("modnãopermitido(pc)")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Mod não permitido (PC)";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 3, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ameaçaàstaff")) {
				if (!p.hasPermission("com.redeforest.bungee.moderador")) {
					p.sendMessage("§cVocê não tem permissão para punir por este motivo.");
					return;
				}
				motivo = "Ameaça à staff";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "BAN", prova, motivo, data, 0, 0, 0);
				return;
			}
			if (motivo.equalsIgnoreCase("ameaçaàjogador")) {
				motivo = "Ameaça à usuário";
				String data = getDayFormated();
				String nick = Manager.pegarNomePlayer(nome);
				PunishAPI.punirJogadorS(nick, p.getName(), "MUTE", prova, motivo, data, 0, 5, 0);
				return;
			}
			p.sendMessage("§cMotivo inválido.");
			return;
		}
		if (args.length > 2) {
			p.sendMessage("§cUtilize /punirs <usuário> para exibir os tipos de infrações.");
			return;
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
