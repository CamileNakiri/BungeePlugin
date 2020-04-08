package com.redeforest.low5tar.redeforestbungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RegrasCommand extends Command {

	public RegrasCommand() {
		super("regras");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) cs;
			p.sendMessage("");
			p.sendMessage("§eTabela de Punições:");
			p.sendMessage("§eLeia as regras e evite ao máximo respeita-las para que não");
			p.sendMessage(" §eseja punido!");
			p.sendMessage("");
			p.sendMessage("  §7§l• §fAbuso de bugs §8- §7Permanente");
			p.sendMessage("  §7§l• §fAntijogo §8- §7Banido por 1 dia");
			p.sendMessage("  §7§l• §fCaps-Lock §8- §7Mutado por 2 horas");
			p.sendMessage("  §7§l• §fConta fake §8- §7Permanente");
			p.sendMessage("  §7§l• §fDivulgação grave §8- §7Permanente");
			p.sendMessage("  §7§l• §fDivulgação simples §8- §7Mutado por 6 horas");
			p.sendMessage("  §7§l• §fFlood §8- §7Mutado por 4 horas");
			p.sendMessage("  §7§l• §fSPAM §8- §7Mutado por 4 horas");
			p.sendMessage("  §7§l• §fChat fake §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l• §fIniciativa de briga §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l• §fIniciativa de flood §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l• §fNickname inapropriado §8- §7Permanente");
			p.sendMessage("  §7§l• §fOfensa á usuário §8- §7Mutado por 6 horas");
			p.sendMessage("  §7§l• §fOfensa á staff/servidor §8- §7Permanente");
			p.sendMessage("  §7§l• §fPalavras inadequadas §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l• §fHashTag §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l• §fEnganar à staff §8- §7Permanente");
			p.sendMessage("  §7§l• §fDeslogar/negar pedido de tela §8- §7Permanente");
			p.sendMessage("  §7§l• §fMod não permitido §8- §7Permanente");
			p.sendMessage("  §7§l• §fMod não permitido (PC) §8- §7Banido por 3 dias");
			p.sendMessage("  §7§l• §fAmeaça à usuário §8- §7Mutado por 5 horas");
			p.sendMessage("  §7§l• §fAmeaça à staff §8- §7Permanente");
			p.sendMessage("  §7§l• §fDesinformação §8- §7Permanente");
			p.sendMessage("  §7§l• §fHack §8- §7Permanente");
			p.sendMessage("");
			p.sendMessage("§cTodas punições acima são aplicadas em mute ou até");
			p.sendMessage("§cbanimentos no tempo especificado.");
			p.sendMessage("");
			return;
		}
	}
}
