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
			sender.sendMessage("§cVocê não tem permissão para executar este comando'.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("§cUtilize /despunir <usuário> para despunir um usuário.");
			return;
		}
		if (args.length >= 1) {
			String nome = args[0];
			if (!Manager.checarContaExiste(nome)) {
				sender.sendMessage("§cConta não encontrada.");
				return;
			}
			if (!PunishAPI.checkPunish(nome)) {
				sender.sendMessage("§cEste usuário não encontra-se punido.");
				return;
			}
			for (String s : Main.getInstance().getProxy().getServers().keySet()) {
				ServerInfo i = (ServerInfo) Main.getInstance().getProxy().getServers().get(s);
				for (ProxiedPlayer todos : i.getPlayers()) {
					if (!todos.hasPermission("com.redeforest.bungee.punir")) continue;
					todos.sendMessage("");
					todos.sendMessage(" §e* " + sender.getName() + " revogou uma punição de " + Manager.pegarNomePlayer(nome) + ".");
					todos.sendMessage(" §e* Aplicada inicialmente por: " + PunishAPI.getAutor(nome) + ".");
					todos.sendMessage("");
				}
			}
			sender.sendMessage("§ePunição revogada com sucesso!");
			int id = PunishAPI.getID(nome);
			PunishAPI.despunirJogador(nome, id);
			return;
		}
	}
}
