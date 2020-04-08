package com.redeforest.low5tar.redeforestbungee.listeners;

import com.redeforest.low5tar.redeforestbungee.utils.Address;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.alpenblock.bungeeperms.BungeePerms;

public class PostLoginListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLogin(PostLoginEvent e) {
		ProxiedPlayer p = e.getPlayer();
		switch (p.getName().toLowerCase()) {
		case "aygdyags":
			if (!Address.getAddres(p).equals("com.redeforest.bungee.admin")) {
				p.disconnect("§c§lREDE FOREST\n§1\n§cVocê é um membro de nossa equipe!\n§cPor favor, logue-se com seu §c§lIP FIXO§c!");
			}
			break;
		}
		switch (BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().get(0).getName().toLowerCase()) {
		case "admin":
			if (p.getName().equalsIgnoreCase("aygdyags")) {
				return;
			} else {
				System.out.println("O [ADMIN] " + p.getName() + " tentou conectar pelo IP '" + Address.getAddres(p) + "'");
				p.disconnect("§c§lREDE FOREST\n§1\n§cVocê é um membro de nossa equipe!\n§cPor favor, logue-se com seu §c§lIP FIXO§c!");
			}
			break;
		case "coordenador":
			if (!Address.getAddres(p).equals("com.redeforest.bungee.coord")) {
				p.disconnect("§c§lREDE FOREST\n§1\n§cVocê é um membro de nossa equipe!\n§cPor favor, logue-se com seu §c§lIP FIXO§c!");
			}
			break;
		case "moderador":
			if (!Address.getAddres(p).equals("com.redeforest.bungee.moderador")) {
				p.disconnect("§c§lREDE FOREST\n§1\n§cVocê é um membro de nossa equipe!\n§cPor favor, logue-se com seu §c§lIP FIXO§c!");
			}
			break;
		case "ajudante":
			if (!Address.getAddres(p).equals("com.redeforest.bungee.ajudante")) {
				p.disconnect("§c§lREDE FOREST\n§1\n§cVocê é um membro de nossa equipe!\n§cPor favor, logue-se com seu §c§lIP FIXO§c!");
			}
			break;
		}
	}
}
