package com.redeforest.low5tar.redeforestbungee.commands;

import java.util.HashMap;

import com.redeforest.low5tar.redeforestbungee.Main;

import net.alpenblock.bungeeperms.BungeePerms;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StCommand
extends Command {
    public StCommand() {
        super("st");
    }

    @SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (!p.hasPermission("com.redeforest.bungee.equipe")) {
        	sender.sendMessage("§cVocê não tem permissão para executar este comando.");
            return;
        }
        if (args.length == 0) {
            String ch;
            p.sendMessage("");
            p.sendMessage("§f§l STAFFERS ONLINE:");
            HashMap<ProxiedPlayer, String> master = new HashMap<ProxiedPlayer, String>();
            HashMap<ProxiedPlayer, String> gerente = new HashMap<ProxiedPlayer, String>();
            HashMap<ProxiedPlayer, String> coordenador = new HashMap<ProxiedPlayer, String>();
            HashMap<ProxiedPlayer, String> admin = new HashMap<ProxiedPlayer, String>();
            HashMap<ProxiedPlayer, String> moderador = new HashMap<ProxiedPlayer, String>();
            HashMap<ProxiedPlayer, String> ajudante = new HashMap<ProxiedPlayer, String>();
            for (String s : Main.getInstance().getProxy().getServers().keySet()) {
                ServerInfo i = Main.getInstance().getProxy().getServers().get(s);
                for (ProxiedPlayer todos : i.getPlayers()) {
                    if (!todos.hasPermission("com.redeforest.bungee.equipe")) continue;
                    int che = 0;
                    try {
                    	if (BungeePerms.getInstance().getPermissionsManager().getUser(todos.getName()).getGroups().contains(BungeePerms.getInstance().getPermissionsManager().getGroup("Admin"))) {
                            master.put(todos, todos.getName());
                            che = 1;
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (todos.hasPermission("com.redeforest.bungee.gerente") && che <= 0) {
                        gerente.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("com.redeforest.bungee.coordenador") && che <= 0) {
                        coordenador.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("com.redeforest.bungee.administrador") && che <= 0) {
                        admin.put(todos, todos.getName());
                        che = 1;
                    }
                    if (todos.hasPermission("com.redeforest.bungee.moderador") && che <= 0) {
                        moderador.put(todos, todos.getName());
                        che = 1;
                    }
                    if (!todos.hasPermission("com.redeforest.bungee.ajudante") || che > 0) continue;
                    ajudante.put(todos, todos.getName());
                    che = 1;
                }
            }
            for (ProxiedPlayer todos : master.keySet()) {
                ch = "";
                if (StaffCommand.cstaff.contains(todos.getName())) {
                    ch = "§c(CHAT OFF)";
                }
                p.sendMessage(" §f➥ " + StCommand.getTag("admin") + " " + todos.getName() + " §8- §7(" + todos.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ") " + ch);
            }
            for (ProxiedPlayer todos : gerente.keySet()) {
                ch = "";
                if (StaffCommand.cstaff.contains(todos.getName())) {
                    ch = "§c(CHAT OFF)";
                }
                p.sendMessage(" §f➥ " + StCommand.getTag("com.redeforest.bungee.gerente") + " " + todos.getName() + " §8- §7(" + todos.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby) + ") " + ch);
            }
            for (ProxiedPlayer todos : coordenador.keySet()) {
                ch = "";
                if (StaffCommand.cstaff.contains(todos.getName())) {
                    ch = "§c(CHAT OFF)";
                }
                p.sendMessage(" §f➥ " + StCommand.getTag("com.redeforest.bungee.coordenador") + " " + todos.getName() + " §8- §7(" + todos.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ") " + ch);
            }
            for (ProxiedPlayer todos : admin.keySet()) {
                ch = "";
                if (StaffCommand.cstaff.contains(todos.getName())) {
                    ch = "§c(CHAT OFF)";
                }
                p.sendMessage(" §f➥ " + StCommand.getTag("com.redeforest.bungee.administrador") + " " + todos.getName() + " §8- §7(" + todos.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ") " + ch);
            }
            for (ProxiedPlayer todos : moderador.keySet()) {
                ch = "";
                if (StaffCommand.cstaff.contains(todos.getName())) {
                    ch = "§c(CHAT OFF)";
                }
                p.sendMessage(" §f➥ " + StCommand.getTag("com.redeforest.bungee.moderador") + " " + todos.getName() + " §8- §7(" + todos.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ") " + ch);
            }
            for (ProxiedPlayer todos : ajudante.keySet()) {
                ch = "";
                if (StaffCommand.cstaff.contains(todos.getName())) {
                    ch = "§c(CHAT OFF)";
                }
                p.sendMessage(" §f➥ " + StCommand.getTag("com.redeforest.bungee.ajudante") + " " + todos.getName() + " §8- §7(" + todos.getServer().getInfo().getName().replaceAll("Lobby", Main.name_lobby).replaceAll("Rankup", Main.name_rankup) + ") " + ch);
            }
            p.sendMessage("");
            return;
        }
    }

    public static String getTag(String grup) {
        if (grup.equalsIgnoreCase("admin")) {
            String tag = "§c[Admin]";
            return tag;
        }
        if (grup.equals("com.redeforest.bungee.gerente")) {
            String tag = "§4[Gerente]";
            return tag;
        }
        if (grup.equals("com.redeforest.bungee.coordenador")) {
            String tag = "§d[Coordenador]";
            return tag;
        }
        if (grup.equals("com.redeforest.bungee.administrador")) {
            String tag = "§c[Administrador]";
            return tag;
        }
        if (grup.equals("com.redeforest.bungee.moderador")) {
            String tag = "§2[Moderador]";
            return tag;
        }
        if (grup.equals("com.redeforest.bungee.ajudante")) {
            String tag = "§e[Ajudante]";
            return tag;
        }
        return null;
    }
}

