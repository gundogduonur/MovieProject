package importcsv;

import java.sql.*;

import com.onurgundogdu.database.DatabaseConnection;

public class Ratings {
	public static void main(String[] args) {
		String PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/ratings.csv";
		writeRatingsCsvDatabase(PATH);
	}
	
	private static void writeRatingsCsvDatabase(String path) {
		
		Connection con = DatabaseConnection.getInstance().getConnection();
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"COPY ratings (userid,movieid,rating,timestamp) FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println("RatingCsv yazdırılamadı");
			e.printStackTrace();
		}
		
	}
}
