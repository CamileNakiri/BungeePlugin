package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.ArrayList;
import java.util.List;

import net.alpenblock.bungeeperms.BungeePerms;
import net.alpenblock.bungeeperms.Group;
import net.alpenblock.bungeeperms.User;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class GrupoCommand extends Command {

	public GrupoCommand() {
		super("grupo");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission("com.redeforest.bungee.groups")) {
			sender.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
		} else if (args.length == 0) {
			sender.sendMessage("");
			sender.sendMessage("�e/grupo adicionar <usu�rio> <grupo>.");
			sender.sendMessage("�e/grupo remover <usu�rio> <grupo>.");
			sender.sendMessage("�e/grupo definir <usu�rio> <grupo>.");
			sender.sendMessage("");
		} else {
			ProxiedPlayer player;
			String group;
			Group groups;
			User user;
			if (args[0].equalsIgnoreCase("adicionar")) {
				if (args.length < 3) {
					sender.sendMessage("�cUtilize /grupo adicionar <usu�rio> <grupo>.");
				} else {
					player = ProxyServer.getInstance().getPlayer(args[1]);
					if (player == null) {
						sender.sendMessage("�cEste usu�rio n�o est� online.");
					} else {
						group = args[2];
						groups = BungeePerms.getInstance().getPermissionsManager().getGroup(group);
						user = BungeePerms.getInstance().getPermissionsManager().getUser(player.getName());
						BungeePerms.getInstance().getPermissionsManager().addUserGroup(user, groups);
						sender.sendMessage("�aUsu�rio adicionado ao grupo " + group + ".");
						player.sendMessage("�aVoc� foi promovido ao cargo de " + group + ".");
					}
				}
			} else if (args[0].equalsIgnoreCase("remover")) {
				if (args.length < 3) {
					sender.sendMessage("�cUtilize /grupo adicionar <usu�rio> <grupo>.");
				} else {
					player = ProxyServer.getInstance().getPlayer(args[1]);
					if (player == null) {
						sender.sendMessage("�cEste usu�rio n�o est� online.");
					} else {
						group = args[2];
						groups = BungeePerms.getInstance().getPermissionsManager().getGroup(group);
						user = BungeePerms.getInstance().getPermissionsManager().getUser(player.getName());
						BungeePerms.getInstance().getPermissionsManager().removeUserGroup(user, groups);
						sender.sendMessage("�aUsu�rio removido do grupo " + group + ".");
					}
				}
			} else if (args[0].equalsIgnoreCase("definir")) {
				if (args.length < 3) {
					sender.sendMessage("�cUtilize /grupo definir <usu�rio> <grupo>.");
				} else {
					player = ProxyServer.getInstance().getPlayer(args[1]);
					if (player == null) {
						sender.sendMessage("�cEste usu�rio n�o est� online.");
					} else {
						group = args[2];
						groups = BungeePerms.getInstance().getPermissionsManager().getGroup(group);
						user = BungeePerms.getInstance().getPermissionsManager().getUser(player.getName());
						List<Group> list = new ArrayList<>();
						list.add(groups);
						user.getGroups().clear();
						sender.sendMessage("�aGrupo do usu�rio " + player.getName() + " definido para " + group + ".");
					}
				}
			}
		}
	}
}