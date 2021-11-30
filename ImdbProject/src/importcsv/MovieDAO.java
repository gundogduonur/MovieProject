package importcsv;

import java.sql.*;
import java.util.*;

import com.onurgundogdu.dto.MoviesCsv;

public class MovieDAO implements IClient<MoviesCsv> {

	private static final String PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/movies.csv";

	public static void main(String[] args) {

		MoviesCsv moviesCsvDto3 = new MoviesCsv();
		moviesCsvDto3.setMovieId(4);

		MovieDAO moviesDao3 = new MovieDAO();
		moviesDao3.delete(moviesCsvDto3);
	}

	public void insert(MoviesCsv t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into movies(title,genres) values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getTitle());
			preparedStatement.setString(2, t.getGenres());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(MoviesCsv.class + "Ekleme bassarılı");
			} else {
				System.out.println("Ekleme sırasında bir hata meydana geldi");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "MoviesCsvDto hata meydana geldi");
			e.printStackTrace();
		}
	}

	public void update(MoviesCsv t) {
		// TODO Auto-generated method stub

	}

	public void delete(MoviesCsv t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from movies where movieId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMovieId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(MoviesCsv.class + "silme bassarılı");
			} else {
				System.out.println("silme sırasında bir hata meydana geldi");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage() + "MoviesCsvDto hata meydana geldi");
		}

	}

	public ArrayList<MoviesCsv> list() {
		// TODO Auto-generated method stub
		return null;
	}


}
