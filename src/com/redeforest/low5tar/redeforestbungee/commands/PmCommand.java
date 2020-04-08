package com.redeforest.low5tar.redeforestbungee.commands;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginDescription;
import org.yaml.snakeyaml.Yaml;

import com.redeforest.low5tar.redeforestbungee.utils.PluginUtils;

public class PmCommand extends Command {

	public PmCommand() {
		super("pluginmanager", "", "pm");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!sender.getName().equalsIgnoreCase("low5tar")) {
			sender.sendMessage(textWithColor("§cVocê não tem permissão para executar este comando.", ChatColor.RED));
			return;
		}
		if (args.length == 0) {
			sender.sendMessage(textWithColor("Utilize /pluginmanager <unload/load/reload> <plugin>.", ChatColor.RED));
			return;
		} else if (args.length == 1) {
			switch (args[0].toLowerCase()) {
			case "list": {
				List<String> plugins = new ArrayList<>();
				for (Plugin plugin : ProxyServer.getInstance().getPluginManager().getPlugins()) {
					plugins.add(plugin.getDescription().getName());
				}
				sender.sendMessage("§fPlugins: §a" + plugins.toString().replaceAll("\\[", "").replaceAll("]", "") + "§f.");
				}
			}
			return;
		}
		switch (args[0].toLowerCase()) {
		case "unload": {
			Plugin plugin = findPlugin(args[1]);
			if (plugin == null) {
				sender.sendMessage(textWithColor(String.format("Plugin '%s' não encontrado.", args[1]), ChatColor.RED));
				return;
			}
			PluginUtils.unloadPlugin(plugin);
			sender.sendMessage(textWithColor(String.format("Plugin '%s' descarregado com sucesso!", plugin.getDescription().getName()),ChatColor.YELLOW));
			break;
		}

		case "load": {
			Plugin plugin = findPlugin(args[1]);
			if (plugin != null) {
				sender.sendMessage(textWithColor("Plugin já está carregado.", ChatColor.RED));
				return;
			}
			File file = findFile(args[1]);
			if (!file.exists()) {
				sender.sendMessage(textWithColor(String.format("Plugin '%s' não encontrado.", args[1]), ChatColor.RED));
				return;
			}
			boolean success = PluginUtils.loadPlugin(file);
			if (success) {
				sender.sendMessage(textWithColor("Plugin carregado com sucesso!", ChatColor.YELLOW));
			} else {
				sender.sendMessage(textWithColor("Ocorreu um erro ao carregar o plugin, acesse o console para mais informações.", ChatColor.RED));
			}
			break;
		}
		case "reload": {
			Plugin plugin = findPlugin(args[1]);
			if (plugin == null) {
				sender.sendMessage(textWithColor(String.format("Plugin '%s' não localizado.", args[1]), ChatColor.RED));
				return;
			}
			File pluginfile = plugin.getFile();
			PluginUtils.unloadPlugin(plugin);
			boolean success = PluginUtils.loadPlugin(pluginfile);
			if (success) {
				sender.sendMessage(textWithColor("Plugin recarregado com sucesso!", ChatColor.YELLOW));
			} else {
				sender.sendMessage(textWithColor("Ocorreu um erro ao carregar o plugin, acesse o console para mais informações.", ChatColor.RED));
			}
		}
	}
}

	static Plugin findPlugin(String pluginName) {
		return ProxyServer.getInstance().getPluginManager().getPlugins().stream().filter(plugin -> plugin.getDescription().getName().equalsIgnoreCase(pluginName)).findFirst().orElse(null);
	}

	static File findFile(String pluginname) {
		File folder = ProxyServer.getInstance().getPluginsFolder();
		if (folder.exists()) {
			File[] pluginFiles = folder.listFiles((File file) -> file.isFile() && file.getName().endsWith(".jar"));
			for (File file : pluginFiles) {
				try (JarFile jar = new JarFile(file)) {
					JarEntry configurationFile = jar.getJarEntry("bungee.yml");
					if (configurationFile == null) {
						configurationFile = jar.getJarEntry("plugin.yml");
					}
					try (InputStream in = jar.getInputStream(configurationFile)) {
						PluginDescription desc = new Yaml().loadAs(in, PluginDescription.class);
						if (desc.getName().equalsIgnoreCase(pluginname)) {
							return file;
						}
					}
				} catch (Throwable ex) {
			}
		}
	}
	return new File(folder, pluginname + ".jar");
}

	static TextComponent textWithColor(String message, ChatColor color) {
		TextComponent text = new TextComponent(message);
		text.setColor(color);
		return text;
	}
}
