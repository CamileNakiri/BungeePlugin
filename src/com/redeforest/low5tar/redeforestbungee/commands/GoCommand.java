package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.redeforest.low5tar.redeforestbungee.Main;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GoCommand extends Command {

	public static ArrayList<String> tello = new ArrayList<String>();
	public static HashMap<String, String> tell = new HashMap<String, String>();

	public GoCommand() {
		super("go");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return;
		}
		if (!sender.hasPermission("com.redeforest.bungee.go")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			sender.sendMessage("�cUtilize /go <usu�rio>.");
			return;
		}
		if (args.length >= 1) {
			String targetNick = args[0];
			ProxiedPlayer target = Main.getInstance().getProxy().getPlayer(targetNick);
			if (p.getName().equalsIgnoreCase(targetNick)) {
				p.sendMessage("�cVoc� n�o pode teleportar para s� mesmo.");
				return;
			}
			if (Main.getInstance().getProxy().getPlayer(targetNick) == null) {
				p.sendMessage("�cEste usu�rio n�o est� on-line.");
				return;
			}
			if (p.getServer().getInfo().getName().contains(target.getServer().getInfo().getName())) {
				p.sendMessage("�cVoc� est� aqui.");
				return;
			}
			if (p.getServer().getAddress().getPort() == target.getServer().getAddress().getPort()) {
				p.sendMessage("�aTeleportando para " + target.getName() + "...");
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("GOCHANNEL");
				out.writeUTF(p.getName());
				target.sendData("GOCHANNEL", out.toByteArray());
			} else {
				p.sendMessage("�aTeleportando para " + target.getName() + "...");
				p.connect(target.getServer().getInfo());
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("GOCHANNEL");
				out.writeUTF("TP");
				target.sendData("GOCHANNEL", out.toByteArray());
			}
		}
	}
}
