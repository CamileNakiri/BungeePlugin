package com.redeforest.low5tar.redeforestbungee.alertbans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.redeforest.low5tar.redeforestbungee.Main;

public class MySQL {
	
	private String user;
	private String host;
	private String database;
	private String password;
	public static Connection connection;
	static Statement statement;

	public MySQL(String user, String password, String host, String database, Main plugin) {
		this.user = user;
		this.password = password;
		this.host = host;
		this.database = database;
	}

	public void startConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.database, this.user, this.password);
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS MOTDGlobal (Baixo VARCHAR(64) NOT NULL, Total VARCHAR(64) NOT NULL)");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
