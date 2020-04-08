package com.redeforest.low5tar.redeforestbungee.punish;

import com.redeforest.low5tar.redeforestbungee.Main;
import com.redeforest.low5tar.redeforestbungee.alertbans.Manager;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class DespunirCommand extends Command {
	
	public DespunirCommand() {
		super("despunir");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission("com.redeforest.bungee.despunir")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando'.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /despunir <usu�rio> para despunir um usu�rio.");
			return;
		}
		if (args.length >= 1) {
			String nome = args[0];
			if (!Manager.checarContaExiste(nome)) {
				sender.sendMessage("�cConta n�o encontrada.");
				return;
			}
			if (!PunishAPI.checkPunish(nome)) {
				sender.sendMessage("�cEste usu�rio n�o encontra-se punido.");
				return;
			}
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = (ServerInfo) Main.getInstance().getProxy().getServers().get(s);
				for (ProxiedPlayer todos : i.getPlayers()) {
					if (!todos.hasPermission("com.redeforest.bungee.punir")) continue;
					todos.sendMessage("");
					todos.sendMessage(" �e* " + sender.getName() + " revogou uma puni��o de " + Manager.pegarNomePlayer(nome) + ".");
					todos.sendMessage(" �e* Aplicada inicialmente por: " + PunishAPI.getAutor(nome) + ".");
					todos.sendMessage("");
				}
			}
			sender.sendMessage("�ePuni��o revogada com sucesso!");
			int id = PunishAPI.getID(nome);
			PunishAPI.despunirJogador(nome, id);
			return;
		}
	}
}
