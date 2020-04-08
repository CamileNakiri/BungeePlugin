package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.ArrayList;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffCommand extends Command {
	
	public static ArrayList<String> cstaff = new ArrayList<String>();

	public StaffCommand() {
		super("s");
	}

	@SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (!p.hasPermission("com.redeforest.bungee.chatstaff")) {
			sender.sendMessage("§cVocê não tem permissão para executar este comando.");
			return;
		}
		if (args.length == 0) {
			p.sendMessage("§cUtilize /s <mensagem> para enviar uma mensagem para toda a staff.");
			return;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("ativar")) {
				if (!cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat da staff já está ativado.");
					return;
				}
				cstaff.remove(p.getName());
				p.sendMessage("§aChat da staff ativado!");
				return;
			}
			if (args[0].equalsIgnoreCase("desativar")) {
				if (cstaff.contains(p.getName())) {
					p.sendMessage("§cSeu chat da staff já está desativado.");
					return;
				}
				cstaff.add(p.getName());
				p.sendMessage("§aChat da staff desativado!");
				return;
			}
		}
		if (args.length > 0) {
			String message = "";
			for (String part : args) {
				if (message != "") {
					message = String.valueOf(message) + " ";
				}
				message = String.valueOf(message) + part;
			}
			String tag = "";
			try {
				if (BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Admin"))) {
	                tag = "§c[Admin]";
	                for (String s : Main.getInstance().getProxy().getServers().keySet()) {
	                    ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
	                    for (ProxiedPlayer todos : i.getPlayers()) {
	                        if (todos.hasPermission("com.redeforest.bungee.chatstaff")) {
	                            if (!StaffCommand.cstaff.contains(todos.getName())) {
	                                todos.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                            }
	                            if (!StaffCommand.cstaff.contains(todos.getName()) || !todos.getName().equals(p.getName())) {
	                                continue;
	                            }
	                            todos.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                    }
	                }
	                return;
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        if (p.hasPermission("com.redeforest.bungee.gerente")) {
	            tag = "§4[Gerente]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("com.redeforest.bungee.chatstaff")) {
	                        if (!StaffCommand.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!StaffCommand.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("com.redeforest.bungee.coordenador")) {
	            tag = "§d[Coordenador]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("com.redeforest.bungee.chatstaff")) {
	                        if (!StaffCommand.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!StaffCommand.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("com.redeforest.bungee.administrador")) {
	            tag = "§c[Administrador]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("com.redeforest.bungee.chatstaff")) {
	                        if (!StaffCommand.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!StaffCommand.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("com.redeforest.bungee.moderador")) {
	            tag = "§2[Moderador]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("com.redeforest.bungee.chatstaff")) {
	                        if (!StaffCommand.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!StaffCommand.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	            return;
	        }
	        if (p.hasPermission("com.redeforest.bungee.ajudante")) {
	            tag = "§e[Ajudante]";
	            for (String s2 : Main.getInstance().getProxy().getServers().keySet()) {
	                ServerInfo j = Main.getInstance().getProxy().getServers().get(s2);
	                for (ProxiedPlayer todos2 : j.getPlayers()) {
	                	if (todos2.hasPermission("com.redeforest.bungee.chatstaff")) {
	                        if (!StaffCommand.cstaff.contains(todos2.getName())) {
	                            todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                        }
	                        if (!StaffCommand.cstaff.contains(todos2.getName()) || !todos2.getName().equals(p.getName())) {
	                            continue;
	                        }
	                        todos2.sendMessage("§d§l[§dS§d§l] §7[" + p.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + "] " + tag + " " + p.getName() + ": §f" + message);
	                    }
	                }
	            }
	        }
		}
	}
}
