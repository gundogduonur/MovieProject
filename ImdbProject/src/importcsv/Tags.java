package importcsv;

import java.sql.*;

import com.onurgundogdu.database.DatabaseConnection;

public class Tags {
	public static void main(String[] args) {
		String PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/tags.csv";
		writeTagsCsvDatabase(PATH);
		
	}
	
	private static void writeTagsCsvDatabase(String path) {
		
		Connection connection = DatabaseConnection.getInstance().getConnection();
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("COPY tags FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println("TagsCsv yazdırılamadı");
			e.printStackTrace();
		}
	}
}
