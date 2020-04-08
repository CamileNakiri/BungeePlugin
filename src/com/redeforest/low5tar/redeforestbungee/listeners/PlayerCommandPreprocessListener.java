package com.redeforest.low5tar.redeforestbungee.listeners;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerCommandPreprocessListener implements Listener {

	@EventHandler
	public void onCommand(ChatEvent e) {
		if (!(e.getSender() instanceof ProxiedPlayer)) {
			if (e.isCommand()) {
				System.out.println("CONSOLE: " + e.getMessage());
			}
		}
		ProxiedPlayer player = (ProxiedPlayer) e.getSender();
		System.out.println(player.getName() + " (" + player.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "): " + e.getMessage());
	}
}
