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
			p.sendMessage("�eTabela de Puni��es:");
			p.sendMessage("�eLeia as regras e evite ao m�ximo respeita-las para que n�o");
			p.sendMessage(" �eseja punido!");
			p.sendMessage("");
			p.sendMessage("  �7�l� �fAbuso de bugs �8- �7Permanente");
			p.sendMessage("  �7�l� �fAntijogo �8- �7Banido por 1 dia");
			p.sendMessage("  �7�l� �fCaps-Lock �8- �7Mutado por 2 horas");
			p.sendMessage("  �7�l� �fConta fake �8- �7Permanente");
			p.sendMessage("  �7�l� �fDivulga��o grave �8- �7Permanente");
			p.sendMessage("  �7�l� �fDivulga��o simples �8- �7Mutado por 6 horas");
			p.sendMessage("  �7�l� �fFlood �8- �7Mutado por 4 horas");
			p.sendMessage("  �7�l� �fSPAM �8- �7Mutado por 4 horas");
			p.sendMessage("  �7�l� �fChat fake �8- �7Mutado por 5 horas");
			p.sendMessage("  �7�l� �fIniciativa de briga �8- �7Mutado por 5 horas");
			p.sendMessage("  �7�l� �fIniciativa de flood �8- �7Mutado por 5 horas");
			p.sendMessage("  �7�l� �fNickname inapropriado �8- �7Permanente");
			p.sendMessage("  �7�l� �fOfensa � usu�rio �8- �7Mutado por 6 horas");
			p.sendMessage("  �7�l� �fOfensa � staff/servidor �8- �7Permanente");
			p.sendMessage("  �7�l� �fPalavras inadequadas �8- �7Mutado por 5 horas");
			p.sendMessage("  �7�l� �fHashTag �8- �7Mutado por 5 horas");
			p.sendMessage("  �7�l� �fEnganar � staff �8- �7Permanente");
			p.sendMessage("  �7�l� �fDeslogar/negar pedido de tela �8- �7Permanente");
			p.sendMessage("  �7�l� �fMod n�o permitido �8- �7Permanente");
			p.sendMessage("  �7�l� �fMod n�o permitido (PC) �8- �7Banido por 3 dias");
			p.sendMessage("  �7�l� �fAmea�a � usu�rio �8- �7Mutado por 5 horas");
			p.sendMessage("  �7�l� �fAmea�a � staff �8- �7Permanente");
			p.sendMessage("  �7�l� �fDesinforma��o �8- �7Permanente");
			p.sendMessage("  �7�l� �fHack �8- �7Permanente");
			p.sendMessage("");
			p.sendMessage("�cTodas puni��es acima s�o aplicadas em mute ou at�");
			p.sendMessage("�cbanimentos no tempo especificado.");
			p.sendMessage("");
			return;
		}
	}
}
