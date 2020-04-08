package com.redeforest.low5tar.redeforestbungee.punish;

import java.util.HashMap;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class PunirAPI {

	public static HashMap<String, String> map = new HashMap<String, String>();

	public static void carregarMotivos() {
		map.put("Abuso de bugs", "Permanente");
		map.put("Antijogo", "Punido por 1 dia");
		map.put("Caps-Lock", "Mutado por 2 horas");
		map.put("Chat fake", "Mutado por 5 horas");
		map.put("Conta fake", "Permanente");
		map.put("Desinformação", "Permanente");
		map.put("Divulgação grave", "Permanente");
		map.put("Divulgação simples", "Mutado por 6 horas");
		map.put("Flood", "Mutado por 4 horas");
		map.put("SPAM", "Mutado por 4 horas");
		map.put("Hack", "Permanente");
		map.put("HashTag", "Mutado por 5 horas");
		map.put("Iniciativa de briga", "Mutado por 5 horas");
		map.put("Iniciativa de flood", "Mutado por 5 horas");
		map.put("Nickname inapropriado", "Permanente");
		map.put("Ofensa à usuário", "Mutado por 6 horas");
		map.put("Ofensa à staff/servidor", "Permanente");
		map.put("Palavras inadequadas", "Mutado por 5 horas");
		map.put("Enganar à staff", "Permanente");
		map.put("Deslogar/negar pedido de tela", "Permanente");
		map.put("Desconhecido", "Permanente");
		map.put("Mod não permitido", "Permanente");
		map.put("Mod não permitido (PC)", "Punido por 3 dias");
		map.put("Ameaça à staff", "Permanente");
		map.put("Ameaça à usuário", "Mutado por 5 horas");
	}

	@SuppressWarnings("deprecation")
	public static void mandarPlayer(CommandSender p, String nome, boolean ch) {
		if (ch) {
			p.sendMessage("AAA");
			p.sendMessage("");
			p.sendMessage("§eSelecione um tipo de infração:");
			for (String tipo : map.keySet()) {
				String jorj = map.get(tipo);
				TextComponent j = new TextComponent("§f" + tipo);
				j.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punirs " + nome + " " + tipo.replace(" ", "").toLowerCase()));
				j.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§e" + tipo + "\n§1" + "\n§f" + jorj + "\n§2" + "\n§eClique para selecionar!").create()));
				p.sendMessage(j);
			}
			p.sendMessage("");
		} else {
			p.sendMessage("");
			p.sendMessage("§eSelecione um tipo de infração:");
			for (String tipo : map.keySet()) {
				String jorj = map.get(tipo);
				TextComponent j = new TextComponent("§f" + tipo);
				j.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/punir " + nome + " " + tipo.replace(" ", "").toLowerCase()));
				j.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§e" + tipo + "\n§1" + "\n§f" + jorj + "\n§2" + "\n§eClique para selecionar!").create()));
				p.sendMessage(j);
			}
			p.sendMessage("");
		}
	}
}
