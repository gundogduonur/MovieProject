package importcsv;

import java.sql.*;

import com.onurgundogdu.database.DatabaseConnection;

public class Movies {
	public static void main(String[] args) {
		String PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/movies.csv";
		writeMoviesCsvDatabase(PATH);
	}
	
	private static void writeMoviesCsvDatabase(String path) {
		
		Connection con = DatabaseConnection.getInstance().getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("COPY movies FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
