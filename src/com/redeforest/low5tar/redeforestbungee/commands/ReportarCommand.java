package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

public class ReportarCommand extends Command implements TabExecutor {

	public static HashMap<String, Date> delay = new HashMap<String, Date>();

	public ReportarCommand() {
		super("reportar", "", "report");
	}

	@SuppressWarnings("deprecation")
	public static void yourself(ProxiedPlayer P) {
		P.sendMessage("§cVocê não pode reportar você mesmo.");
	}

	@SuppressWarnings("deprecation")
	public static void offline(ProxiedPlayer P, String targetname) {
		P.sendMessage("§cEste usuário não está on-line.");
	}

	@SuppressWarnings({ "deprecation" })
	public void execute(CommandSender cs, String[] args) {
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) cs;
			if (args.length < 2) {
				player.sendMessage("§cUtilize /reportar <usuário> <motivo>.");
				return;
			}
			String Targetname = args[0];
			ProxiedPlayer pls = BungeeCord.getInstance().getPlayer(Targetname);
			if (pls == null) {
				offline(player, Targetname);
				return;
			}
			if (pls == player) {
				yourself(player);
				return;
			}
			if (pls.hasPermission("com.redeforest.bungee.punir")) {
				player.sendMessage("§cVocê não pode reportar um membro da equipe.");
				return;
			}
			if (args.length > 1) {
				if (delay.containsKey(player.getName())) {
					Date now = new Date();
					if (now.after(delay.get(player.getName()))) {
						delay.remove(player.getName());
					} else {
						player.sendMessage("§cAguarde um pouco para reportar novamente.");
						return;
					}
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]).append(" ");
				}
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("PatraoChannel");
				out.writeUTF("Toque");
				String allArgs = sb.toString().trim();
				if (!allArgs.equalsIgnoreCase("aimbot")
						&& !allArgs.equalsIgnoreCase("autoarmor")
						&& !allArgs.equalsIgnoreCase("chestfinder")
						&& !allArgs.equalsIgnoreCase("clientealt")
						&& !allArgs.equalsIgnoreCase("critical")
						&& !allArgs.equalsIgnoreCase("fastplace")
						&& !allArgs.equalsIgnoreCase("fly")
						&& !allArgs.equalsIgnoreCase("forcefield")
						&& !allArgs.equalsIgnoreCase("nofall")
						&& !allArgs.equalsIgnoreCase("noslow")
						&& !allArgs.equalsIgnoreCase("regen")
						&& !allArgs.equalsIgnoreCase("repulsao")
						&& !allArgs.equalsIgnoreCase("speed")
						&& !allArgs.equalsIgnoreCase("wall")
						&& !allArgs.equalsIgnoreCase("xray")
						&& !allArgs.equalsIgnoreCase("hack")) {
					player.sendMessage("");
					player.sendMessage("§eTabela de Motivos:");
					player.sendMessage("");
					player.sendMessage("  §7§l• §fhack");
					player.sendMessage("  §7§l• §faimbot");
					player.sendMessage("  §7§l• §fautoarmor");
					player.sendMessage("  §7§l• §fchestfinder");
					player.sendMessage("  §7§l• §fclientealt");
					player.sendMessage("  §7§l• §fcritical");
					player.sendMessage("  §7§l• §ffastplace");
					player.sendMessage("  §7§l• §ffly");
					player.sendMessage("  §7§l• §fforcefield");
					player.sendMessage("  §7§l• §fnofall");
					player.sendMessage("  §7§l• §fnoslow");
					player.sendMessage("  §7§l• §fregen");
					player.sendMessage("  §7§l• §frepulsao");
					player.sendMessage("  §7§l• §fspeed");
					player.sendMessage("  §7§l• §fwall");
					player.sendMessage("  §7§l• §fxray");
					player.sendMessage("");
					return;
				}
				for (ProxiedPlayer pls2 : BungeeCord.getInstance().getPlayers()) {
					if (pls2.hasPermission("com.redeforest.bungee.punir")) {
						pls2.getServer().sendData("PatraoChannel", out.toByteArray());
						pls2.sendMessage("");
						pls2.sendMessage(" §e* " + args[0] + " foi reportado por " + player.getName() + ".");
						pls2.sendMessage(" §e* Motivo: " + allArgs);
						pls2.sendMessage(" §e* Servidor: " + player.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup));
						pls2.sendMessage("");
					}
				}
				player.sendMessage("§a * Você reportou o usuário §7" + args[0] + "§a. Um membro de nossa equipe foi notificado e o comportamento desde usuário será analisado em breve.");
				player.sendMessage("");
				player.sendMessage("§a * O uso abusivo deste comando poderá resultar em punição.");
				if (delay.containsKey(player.getName())) {
					delay.remove(player.getName());
				}
				Date na = new Date();
				na.setSeconds(na.getSeconds() + 60);
				delay.put(player.getName(), na);
			}
		}
	}

	public Iterable<String> onTabComplete(CommandSender cs, String[] args) {
		if (args.length <= 2) {
		}
		Set<String> match = new HashSet<String>();
		if (args.length == 1) {
			String search = args[0].toLowerCase();
			for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
				if (player.getName().toLowerCase().startsWith(search)) {
					match.add(player.getName());
				}
			}
		}
		return match;
	}
}
