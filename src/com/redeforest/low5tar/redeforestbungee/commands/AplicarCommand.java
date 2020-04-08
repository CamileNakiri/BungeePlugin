package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class AplicarCommand extends Command {

	public AplicarCommand() {
		super("aplicar");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) cs;
			p.sendMessage("");
			p.sendMessage(" §a* Para requisitar o formulário, acesse nosso Discord:");
			p.sendMessage(" §a* §f" + Main.discord);
			p.sendMessage("");
			return;
		}
	}
}
