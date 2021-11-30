package com.onurgundogdu.dao;

import java.sql.*;
import java.util.*;

import com.onurgundogdu.database.DatabaseConnection;
import com.onurgundogdu.dto.MoviesCsv;

public class SearchDatabase implements ISearchDatabase {

	public ArrayList<MoviesCsv> daoClientSearchByYear(String year) {
		ArrayList<MoviesCsv> list = new ArrayList<MoviesCsv>();
		MoviesCsv moviesCsvDto;

		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
			String sql = "select m.movieid,m.genres,m.title from movies as m where m.title like ?";
			;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + year + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsvDto = new MoviesCsv();
				moviesCsvDto.setMovieId(resultSet.getInt("movieid"));
				moviesCsvDto.setTitle(resultSet.getString("title"));
				moviesCsvDto.setGenres(resultSet.getString("genres"));
				list.add(moviesCsvDto);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ArrayList<MoviesCsv> daoClientSearchByCategory(String searchCategory) {
		ArrayList<MoviesCsv> list = new ArrayList<MoviesCsv>();
		MoviesCsv moviesCsvDto;

		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {

			String sql = "select SUBSTRING(m.title,length(m.title)-4,4) as yil,m.movieid,m.title from movies as m "
					+ "where LOWER(m.genres) like ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + searchCategory.toLowerCase() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsvDto = new MoviesCsv();
				moviesCsvDto.setMovieId(resultSet.getInt("movieid"));
				moviesCsvDto.setTitle(resultSet.getString("title"));
				moviesCsvDto.setYears(resultSet.getString("yil"));
				list.add(moviesCsvDto);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<MoviesCsv> daoClientSearchByMoviesName(String name) {
		ArrayList<MoviesCsv> list = new ArrayList<MoviesCsv>();
		MoviesCsv moviesCsvDto;
		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
			String sql = "select SUBSTRING(m.title,length(m.title)-4,4) as yil,title,max(ratings.rating),min(ratings.rating),avg(ratings.rating) from ratings "
					+ "inner join movies as m on ratings.movieid = m.movieid  where lower(m.title) like ? group by title";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name.toLowerCase() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsvDto = new MoviesCsv();

				moviesCsvDto.setTitle(resultSet.getString("title"));
				moviesCsvDto.setMaxRating(resultSet.getDouble("max"));
				moviesCsvDto.setMinRating(resultSet.getDouble("min"));
				moviesCsvDto.setAverageRating(resultSet.getDouble("avg"));
				moviesCsvDto.setYears(resultSet.getString("yil"));
				list.add(moviesCsvDto);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<MoviesCsv> daoClientSearchByArtistName(String artistName) {
		ArrayList<MoviesCsv> list = new ArrayList<>();
		MoviesCsv moviesCsv;
		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
			String queryArtist = "SELECT m.movieid,t.tag,m.genres, m.title, AVG(r.rating),MAX(r.rating),MIN(r.rating), SUBSTRING(trim(m.title), length(trim(m.title))-4,4) as movie_year"
					+ " FROM movies as m" + " INNER JOIN tags as t ON t.movieid = m.movieid"
					+ " INNER JOIN ratings as r ON r.movieid = m.movieid"
					+ " WHERE LOWER(t.tag) LIKE ? GROUP BY t.tag,m.title,m.movieid,m.genres ORDER BY movie_year DESC;";
			PreparedStatement preparedStatement = connection.prepareStatement(queryArtist);
			preparedStatement.setString(1, "%" + artistName.toLowerCase() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsv = new MoviesCsv();
				moviesCsv.setMovieId(resultSet.getInt("movieid"));
				moviesCsv.setTitle(resultSet.getString("title"));
				moviesCsv.setGenres(resultSet.getString("genres"));
				moviesCsv.setMaxRating(resultSet.getDouble("max"));
				moviesCsv.setMinRating(resultSet.getDouble("min"));
				list.add(moviesCsv);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
}
