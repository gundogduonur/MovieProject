package com.onurgundogdu.server;

import java.io.*;
import java.util.*;

import com.onurgundogdu.controller.Controller;
import com.onurgundogdu.dto.ArtistTsv;
import com.onurgundogdu.dto.MoviesCsv;
import com.onurgundogdu.dto.MoviesTsv;

import java.net.*;

public class Server {
	public void runServer() {

		try (ServerSocket serverSocket = new ServerSocket(3566)) {

			System.out.println("Ready Server");
			while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("Bağlantı: " + socket);

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			
				String searchKey = null;
				if ((searchKey = dataInputStream.readUTF()) != null) {

					System.out.println("Search word: " + searchKey);
					String[] array = searchKey.split("&");
					if (array[1].equals("movie")) {
						System.out.println("Searching movie in TSV" + array[0]);
						MoviesTsv result = fileReaderMoviesTryWithResources(array[0]);

						out.writeObject(result);
					} else {
						System.out.println("Searching artist in TSV" + array[0]);
						ArtistTsv result = fileReaderNameCsvTryWithResources(array[0]);

						out.writeObject(result);
					}
					System.out.println("Send message.");
				}

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public MoviesTsv fileReaderMoviesTryWithResources(String searchKey) {
		MoviesTsv movTsv = null;

		String satir = "";
		String path = "/Users/onurgundogdu/Desktop/movies.tsv";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			while ((satir = bufferedReader.readLine()) != null) {

				if (satir.toLowerCase().contains(searchKey.toLowerCase())) {

					StringTokenizer stringTokenizer = new StringTokenizer(satir, "\t");
					movTsv = new MoviesTsv(stringTokenizer.nextToken(), stringTokenizer.nextToken(),
							stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(),
							stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(),
							stringTokenizer.nextToken());
					ArrayList<MoviesCsv> list = Controller.getInstance()
							.daoClientSearchByMoviesName(movTsv.getPrimaryTitle());
					if (list.size() > 0) {
						MoviesCsv movCsv = list.get(0);
						movTsv.setYears(movCsv.getYears());
						movTsv.setMaxRating(movCsv.getMaxRating());
						movTsv.setMinRating(movCsv.getMinRating());
						movTsv.setAverageRating(movCsv.getAverageRating());
					}
					System.out.println("Found movie**");
					break;
				}

			}
			if (movTsv == null) {
				System.out.println("Dont find movie");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return movTsv;
	}

	public ArtistTsv fileReaderNameCsvTryWithResources(String searchKey) {

		String satir = "";
		String path = "/Users/onurgundogdu/Desktop/names.tsv";
		ArtistTsv temp = null;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			while ((satir = bufferedReader.readLine()) != null) {

				if (satir.toLowerCase().contains(searchKey.toLowerCase())) {
					StringTokenizer stringTokenizer = new StringTokenizer(satir, "\t");
					temp = new ArtistTsv();
					if (stringTokenizer.hasMoreTokens()) {
						temp.setNconst(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setPrimaryName(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setBirthYear(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setDeathYear(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setPrimaryProfession(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setKnownForTitles(stringTokenizer.nextToken());
					}
					String[] tconst = temp.getKnownForTitles().split("[,]");
					ArrayList<MoviesTsv> listMovie = new ArrayList<MoviesTsv>();
					for (int i = 0; i < tconst.length; i++) {
						MoviesTsv movTsv = fileReaderMoviesTryWithResources(tconst[i]);

						listMovie.add(movTsv);
					}
					temp.setListMovie(listMovie);

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

}
