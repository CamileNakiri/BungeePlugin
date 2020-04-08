package com.redeforest.low5tar.redeforestbungee.punish;

import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfopCommand extends Command {
	
	public InfopCommand() {
		super("info");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.punir")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /info <usu�rio> para ver as informa��es da puni��o.");
			return;
		}
		if (args.length >= 1) {
			String nome = args[0];
			int id = PunishAPI.getID(nome);
			if (!Manager.checarContaExiste(nome)) {
				p.sendMessage("�cConta n�o encontrada.");
				return;
			}
			if (!PunishAPI.checkPunish(nome)) {
				p.sendMessage("�cEste usu�rio n�o encontra-se punido.");
				return;
			}
			p.sendMessage("");
			p.sendMessage("�f Informa��es:");
			p.sendMessage("");
			if (PunishAPI.temFim(nome)) {
				p.sendMessage("�c O usu�rio " + nome + " est� banido");
				p.sendMessage("�c at� o dia �e" + PunishAPI.getDataF(nome) + "�c.");
				p.sendMessage("");
			}
			p.sendMessage("�f Conta punida: �7" + nome);
			p.sendMessage("�f Data: �7" + PunishAPI.getData(nome).replace("N", "Indefinido."));
			p.sendMessage("�f Motivo: �7" + PunishAPI.getMotivo(nome).replace("N", "Indefinido."));
			p.sendMessage("�f Prova: �7" + PunishAPI.getProva(nome).replace("N", "Indefinido."));
			p.sendMessage("�f Autor: �7" + PunishAPI.getAutor(nome).replace("N", "Indefinido."));
			p.sendMessage("");
			p.sendMessage("�f Tipo: �7" + PunishAPI.getTipo(nome));
			p.sendMessage("�f ID: �7#" + id);
			p.sendMessage("");
			return;
		}
	}
}
