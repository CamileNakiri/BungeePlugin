package com.redeforest.low5tar.redeforestbungee;

import java.io.File;
import java.io.IOException;

import com.redeforest.low5tar.redeforestbungee.alertbans.MySQL;
import com.redeforest.low5tar.redeforestbungee.alertbans.ShedulerBan;
import com.redeforest.low5tar.redeforestbungee.commands.AlertaCommand;
import com.redeforest.low5tar.redeforestbungee.commands.AplicarCommand;
import com.redeforest.low5tar.redeforestbungee.commands.BunkerCommand;
import com.redeforest.low5tar.redeforestbungee.commands.ClearChatCommand;
import com.redeforest.low5tar.redeforestbungee.commands.CoresCommand;
import com.redeforest.low5tar.redeforestbungee.commands.FindCommand;
import com.redeforest.low5tar.redeforestbungee.commands.GoCommand;
import com.redeforest.low5tar.redeforestbungee.commands.GrupoCommand;
import com.redeforest.low5tar.redeforestbungee.commands.InfoCommand;
import com.redeforest.low5tar.redeforestbungee.commands.LobbyCommand;
import com.redeforest.low5tar.redeforestbungee.commands.OnlineCommand;
import com.redeforest.low5tar.redeforestbungee.commands.PatraoCommand;
import com.redeforest.low5tar.redeforestbungee.commands.PmCommand;
import com.redeforest.low5tar.redeforestbungee.commands.RCommand;
import com.redeforest.low5tar.redeforestbungee.commands.RedesCommand;
import com.redeforest.low5tar.redeforestbungee.commands.RegrasCommand;
import com.redeforest.low5tar.redeforestbungee.commands.ReportarCommand;
import com.redeforest.low5tar.redeforestbungee.commands.SendCommand;
import com.redeforest.low5tar.redeforestbungee.commands.ServerCommand;
import com.redeforest.low5tar.redeforestbungee.commands.StCommand;
import com.redeforest.low5tar.redeforestbungee.commands.StaffCommand;
import com.redeforest.low5tar.redeforestbungee.commands.TellCommand;
import com.redeforest.low5tar.redeforestbungee.commands.YtCommand;
import com.redeforest.low5tar.redeforestbungee.config.Settings;
import com.redeforest.low5tar.redeforestbungee.listeners.PlayerCommandPreprocessListener;
import com.redeforest.low5tar.redeforestbungee.manutenção.ManutençãoCommand;
import com.redeforest.low5tar.redeforestbungee.manutenção.ManutençãoListener;
import com.redeforest.low5tar.redeforestbungee.motd.MOTDCommand;
import com.redeforest.low5tar.redeforestbungee.motd.MOTDListener;
import com.redeforest.low5tar.redeforestbungee.punish.DespunirCommand;
import com.redeforest.low5tar.redeforestbungee.punish.HistCommand;
import com.redeforest.low5tar.redeforestbungee.punish.InfopCommand;
import com.redeforest.low5tar.redeforestbungee.punish.KickCommand;
import com.redeforest.low5tar.redeforestbungee.punish.PunirCommand;
import com.redeforest.low5tar.redeforestbungee.punish.PunirAPI;
import com.redeforest.low5tar.redeforestbungee.punish.PunirSCommand;
import com.redeforest.low5tar.redeforestbungee.punish.WarnCommand;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {
	
	public static MySQL sql;
	private static Main instance;
	public Settings configg;
    public static Configuration config;
    public static File file;
    public static String name_lobby = "Lobby";
    public static String name_rankup = "Rankup";
    public static String discord = "discord.gg/forest";

	public Main() {
		Main.instance = this;
	}

	public static Main getInstance() {
		return instance;
	}

	@SuppressWarnings("deprecation")
	public void onEnable() {
		instance = this;
		configg = new Settings();
		getProxy().getPluginManager().registerCommand(this, new WarnCommand());
		getProxy().getPluginManager().registerCommand(this, new RedesCommand());
		getProxy().getPluginManager().registerCommand(this, new RegrasCommand());
		getProxy().getPluginManager().registerCommand(this, new ReportarCommand());
		getProxy().getPluginManager().registerCommand(this, new PmCommand());
		getProxy().getPluginManager().registerCommand(this, new ClearChatCommand());
		getProxy().getPluginManager().registerCommand(this, new AplicarCommand());
		getProxy().getPluginManager().registerCommand(this, new SendCommand());
		getProxy().getPluginManager().registerCommand(this, new AlertaCommand());
		getProxy().getPluginManager().registerCommand(this, new CoresCommand());
		getProxy().getPluginManager().registerCommand(this, new FindCommand());
		getProxy().getPluginManager().registerCommand(this, new GrupoCommand());
		getProxy().getPluginManager().registerCommand(this, new InfoCommand());
		getProxy().getPluginManager().registerCommand(this, new YtCommand());
		getProxy().getPluginManager().registerCommand(this, new OnlineCommand());
		getProxy().getPluginManager().registerCommand(this, new LobbyCommand());
		getProxy().getPluginManager().registerCommand(this, new StaffCommand());
		getProxy().getPluginManager().registerCommand(this, new StCommand());
		getProxy().getPluginManager().registerCommand(this, new ServerCommand());
		getProxy().getPluginManager().registerCommand(this, new TellCommand());
		getProxy().getPluginManager().registerCommand(this, new RCommand());
		getProxy().getPluginManager().registerCommand(this, new PatraoCommand());
		getProxy().getPluginManager().registerCommand(this, new PunirCommand());
		getProxy().getPluginManager().registerCommand(this, new InfopCommand());
		getProxy().getPluginManager().registerCommand(this, new PunirSCommand());
		getProxy().getPluginManager().registerCommand(this, new DespunirCommand());
		getProxy().getPluginManager().registerCommand(this, new KickCommand());
		getProxy().getPluginManager().registerCommand(this, new HistCommand());
		getProxy().getPluginManager().registerCommand(this, new ManutençãoCommand());
		getProxy().getPluginManager().registerCommand(this, new MOTDCommand());
		getProxy().getPluginManager().registerCommand(this, new BunkerCommand());
		getProxy().getPluginManager().registerCommand(this, new GoCommand());
		getProxy().getPluginManager().registerListener(this, new MOTDListener());
		getProxy().getPluginManager().registerListener(this, new ManutençãoListener());
		getProxy().getPluginManager().registerListener(this, new PlayerCommandPreprocessListener());
		//getProxy().getPluginManager().registerListener(this, new PostLoginListener());
		getProxy().registerChannel("PatraoChannel");
		getProxy().registerChannel("MutePunish");
		getProxy().registerChannel("GOCHANNEL");
		setupSQL();
		ShedulerBan.iniciarSheduler();
		//Avisos.iniciarSheduler();
		PunirAPI.carregarMotivos();
		if (!MOTDListener.dadosExistem()) {
			MOTDListener.adicionarDados();
		}
		MOTDListener.carregarInfos();
		for (String s : getInstance().getProxy().getServers().keySet()) {
			ServerInfo i = getInstance().getProxy().getServers().get(s);
			int port = i.getAddress().getPort();
			if (!ManutençãoListener.checarExiste(port)) {
				ManutençãoListener.registrarServer(port);
				getInstance().getProxy().getConsole().sendMessage("§eServidor '" + i.getName() + "' registrado no sistema de manutenção.");
			}
		}
        try {
            file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
            	file.createNewFile();
            }
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void onDisable() {
	}

	public void setupSQL() {
		String user = "mc_27";
		String password = "4aa284d88d";
		String host = "0.0.0.0";
		String database = "mc_27";
		sql = new MySQL(user, password, host, database, this);
		sql.startConnection();
	}
}

