package com.redeforest.low5tar.redeforestbungee.alertbans;

import java.io.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.config.*;
import java.util.*;
import java.util.concurrent.*;

import com.redeforest.low5tar.redeforestbungee.Main;

public class Avisos {

	public static String last = "";
	public static HashMap<String, String> aviso = new HashMap<String, String>();

	public static void iniciarSheduler() {
		Main.getInstance().getProxy().getScheduler().schedule(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				try {
					Main.file = new File(Main.getInstance().getDataFolder(), "config.yml");
					if (!Main.file.exists()) {
						Main.file.createNewFile();
					}
					Main.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(Main.getInstance().getDataFolder(), "config.yml"));
					ConfigurationProvider.getProvider(YamlConfiguration.class).save(Main.config, Main.file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Configuration config = Main.config;
				if (config.getString("avisos") != null) {
					int ch = 0;
					for (String st : config.getSection("avisos").getKeys()) {
						if (ch == 0) {
							if (config.getSection("avisos").getKeys().size() > 1) {
								if (Avisos.last.equals(st)) {
									continue;
								}
								++ch;
								Avisos.last = st;
								List<String> list = new ArrayList<String>();
								List<String> json = new ArrayList<String>();
								String url = "";
								for (String lin : config.getStringList("avisos." + st)) {
									int i = 0;
									if (lin.contains("{url}")) {
										url = lin.replace("{url}", "");
										++i;
									}
									if (i == 0 && lin.contains("{json}")) {
										json.add(lin.replace("{json}", "").replace("&", "§"));
										++i;
									}
									if (i == 0) {
										list.add(lin.replace("&", "§"));
									}
								}
								if (list.size() <= 0) {
									continue;
								}
								TextComponent j = new TextComponent("");
								boolean foi = false;
								for (String lin2 : list) {
									if (!foi) {
										j.addExtra(lin2);
										foi = true;
									} else {
										j.addExtra("\n" + lin2);
									}
								}
								if (json.size() > 0) {
									String add = "";
									for (String jsn : json) {
										if (add.equals("")) {
											add = jsn;
										} else {
											add = String.valueOf(add) + "\n" + jsn;
										}
									}
									j.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(add).create()));
								}
								if (!url.equals("")) {
									j.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
								}
								for (String s : Main.getInstance().getProxy().getServers().keySet()) {
									ServerInfo k = Main.getInstance().getProxy().getServers().get(s);
									for (ProxiedPlayer todos : k.getPlayers()) {
										todos.sendMessage((BaseComponent) j);
									}
								}
							} else {
								++ch;
								Avisos.last = st;
								List<String> list = new ArrayList<String>();
								List<String> json = new ArrayList<String>();
								String url = "";
								for (String lin : config.getStringList("avisos." + st)) {
									int i = 0;
									if (lin.contains("{url}")) {
										url = lin.replace("{url}", "");
										++i;
									}
									if (i == 0 && lin.contains("{json}")) {
										json.add(lin.replace("{json}", "").replace("&", "§"));
										++i;
									}
									if (i == 0) {
										list.add(lin.replace("&", "§"));
									}
								}
								if (list.size() <= 0) {
									continue;
								}
								TextComponent j = new TextComponent("");
								boolean foi = false;
								for (String lin2 : list) {
									if (!foi) {
										j.addExtra(lin2);
										foi = true;
									} else {
										j.addExtra("\n" + lin2);
									}
								}
								if (json.size() > 0) {
									String add = "";
									for (String jsn : json) {
										if (add.equals("")) {
											add = jsn;
										} else {
											add = String.valueOf(add) + "\n" + jsn;
										}
									}
									j.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(add).create()));
								}
								if (!url.equals("")) {
									j.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
								}
								for (String s : Main.getInstance().getProxy().getServers().keySet()) {
									ServerInfo k = Main.getInstance().getProxy().getServers().get(s);
									for (ProxiedPlayer todos : k.getPlayers()) {
										todos.sendMessage((BaseComponent) j);
									}
								}
							}
						}
					}
				}
			}
		}, 5L, 5L, TimeUnit.MINUTES);
	}
}
