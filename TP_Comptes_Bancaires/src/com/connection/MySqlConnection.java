package com.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	private Connection connect;
	// URL de connexion
	private String url = "jdbc:mysql://localhost:3306/comptes";
	// Nom du user
	private String user = "root";
	// Mot de passe de l'utilisateur
	private String passwd = "";
	// Objet Connection

	// Constructeur privé
	public MySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public Connection getInstance() {
		if (connect == null) {
			new MySqlConnection();
		}
		return connect;
	}
}