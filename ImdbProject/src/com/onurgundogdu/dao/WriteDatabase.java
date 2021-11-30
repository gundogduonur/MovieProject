package com.onurgundogdu.dao;

import java.io.*;
import java.sql.*;

import com.onurgundogdu.database.DatabaseConnection;

public class WriteDatabase implements IWriteCsv {

	
	public void writeCsvDatabase() {
		
		if (deletedatabase()) {
			createDatabase();
			
			createTables();
			csvWriteDatabase();
		} else {
			System.out.println("Please close other opened guest");
		}
	}
	
	private void createTables() {
		try (Connection con = getInterfaceConnection()) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(readSqlCreateDatabase());
		} catch (SQLException e) {
			System.out.println("Dont create table");
		}
		
	}
	
	private void createDatabase() {
		try (Connection con = DatabaseConnection.getInstance().getConnectionMain()) {
			Statement stmt = con.createStatement();
			String query = "CREATE DATABASE maratonaratatil WITH OWNER = postgres ENCODING = 'UTF8' "
					+ "LC_CTYPE = 'Turkish_Turkey.1254' CONNECTION LIMIT = -1;";
			System.out.println(query);
			stmt.executeUpdate(query);
			System.out.println("Created Database");
			Thread.sleep(1000);
		} catch (SQLException | InterruptedException e) {
			System.out.println("Dont create database");
		}
		
	}
	
	private void csvWriteDatabase() {
		
		String PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/movies.csv";
		writeMoviesCsvDatabase(PATH);
		
		PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/links.csv";
		writeLinksCsvDatabase(PATH);
		
		PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/ratings.csv";
		writeRatingsCsvDatabase(PATH);
		
		PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/tags.csv";
		writeTagsCsvDatabase(PATH);
	}
	
	private boolean deletedatabase() {
		
		java.sql.Statement stmt;
		try (Connection con = DatabaseConnection.getInstance().getConnectionMain()) {
			stmt = con.createStatement();
			stmt.executeUpdate("drop database IF EXISTS maratonaratatil");
			System.out.println("Deleted database.");
			Thread.sleep(1000);
			
			return true;
		} catch (SQLException | InterruptedException e) {
			System.out.println("Dont delete database");
			return false;
		}
		
	}
	
	private void writeLinksCsvDatabase(String path) {
		
		java.sql.Statement stmt;
		try (Connection con = getInterfaceConnection()) {
			stmt = con.createStatement();
			stmt.executeUpdate("COPY links from '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	private void writeMoviesCsvDatabase(String path) {
		
		try (Connection con = getInterfaceConnection()) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("COPY movies FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void writeRatingsCsvDatabase(String path) {
		
		try (Connection con = getInterfaceConnection()) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"COPY ratings(userid,movieid,rating,timestamp) FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			
		}
		
	}
	
	private void writeTagsCsvDatabase(String path) {
		
		try (Connection connection = getInterfaceConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("COPY tags FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			
		}
	}
	
	public String readSqlCreateDatabase() {
		
		StringBuffer srBuffer = new StringBuffer();
		
		try {
			
			String lineString = "";
			
			String tsvPath = "./src/com/onurgundogdu/database/CreateDatabase.sql";
			
			File tsvFile = new File(tsvPath);
			
			@SuppressWarnings("resource")
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(tsvFile));
			
			while ((lineString = bufferedReader.readLine()) != null) {
				
				srBuffer.append(lineString).append("\n");
				
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		return srBuffer.toString();
		
	}


}
