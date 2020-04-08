package com.redeforest.low5tar.redeforestbungee.motd;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MOTDCommand extends Command {
	
	public MOTDCommand() {
		super("motd");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.motd")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
			return;
		}
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /motd <MOTD> para editar a MOTD do servidor.");
			return;
		}
		if (args.length > 0) {
			String message = "";
			String[] arrayOfString;
			int j = (arrayOfString = args).length;
			for (int i = 0; i < j; i++) {
				String part = arrayOfString[i];
				if (message != "") {
					message = message + " ";
				}
				message = message + part;
			}
			message = message.replace("&", "�");
			MOTDListener.setarBaixo(message);
			p.sendMessage("�aVoc� alterou a MOTD do servidor.");
			return;
		}
	}
}
