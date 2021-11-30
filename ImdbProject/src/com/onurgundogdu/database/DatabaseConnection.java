package com.onurgundogdu.database;

import java.sql.*;


public class DatabaseConnection {
	private Connection connection;
	private Connection connectionMain;
	
	private static DatabaseInformation databaseInformation;
	
	private String url = databaseInformation.getUrl();
	private String url2 = databaseInformation.getUrl2();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();
	
		private static DatabaseConnection instance;
	
	private DatabaseConnection() {
		
	}
	
	static {
		databaseInformation = new DatabaseInformation();
				
	}
	
	public static DatabaseConnection getInstance() {
		
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("Installed postgre-sql driver.");
			
			this.connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Succesfully Connected.");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return connection;
	}
	
		
	public Connection getConnectionMain() {
		
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("Installed postgre-sql driver.");
			
			this.connectionMain = DriverManager.getConnection(url2, userName, password);
			System.out.println("Succesfully Connected.");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return connectionMain;
	}
}
