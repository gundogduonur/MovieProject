package importcsv;

import java.sql.*;

import com.onurgundogdu.database.DatabaseConnection;

public class Links {
	public static void main(String[] args) {
		String PATH ="/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/links.csv";

		writeLinksCsvDatabase(PATH);

	}

	public static void writeLinksCsvDatabase(String path) {

		Connection con = DatabaseConnection.getInstance().getConnection();

		java.sql.Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("COPY links from '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
