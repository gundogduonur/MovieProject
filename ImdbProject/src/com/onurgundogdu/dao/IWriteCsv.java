package com.onurgundogdu.dao;

import java.sql.*;

import com.onurgundogdu.database.DatabaseConnection;

public interface IWriteCsv {
	public void writeCsvDatabase();

	default Connection getInterfaceConnection() {

		return DatabaseConnection.getInstance().getConnection();

	}
}
