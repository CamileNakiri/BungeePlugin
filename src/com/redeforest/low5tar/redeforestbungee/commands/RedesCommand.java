package com.redeforest.low5tar.redeforestbungee.commands;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RedesCommand extends Command {

	public RedesCommand() {
		super("rede", "", "redes");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) cs;
			p.sendMessage("");
			p.sendMessage(" §eAcesso úteis da rede:");
			p.sendMessage(" §eTwitter: §fhttps://twitter.com/redeforest");
			p.sendMessage(" §eDiscord: §f" + Main.discord);
			p.sendMessage(" §eSite: §fhttp://redeforest.com");
			p.sendMessage("");
			return;
		}
	}
}
