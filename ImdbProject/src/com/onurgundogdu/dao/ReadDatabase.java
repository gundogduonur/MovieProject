package com.onurgundogdu.dao;

import java.io.*;

public class ReadDatabase implements Serializable {

	private static final long serialVersionUID = 8468865962127279871L;

	public void readCsvDatabase() {
		csvReadDatabase();

	}

	private void csvReadDatabase() {
		String PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/links.csv";
		readLinksCsvDatabase(PATH);

		PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/movies.csv";
		readMoviesCsvDatabase(PATH);

		PATH = "/Users/onurgundogdu/eclipse-workspace/ImdbProject/src/tags.csv";
		readTagsCsvDatabase(PATH);
	}

	private void readTagsCsvDatabase(String path) {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			String toplamSatirlar = "";
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void readRatingsCsvDatabase(String path) {
		// TODO Auto-generated method stub

	}

	private void readMoviesCsvDatabase(String path) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			String toplamSatirlar = "";
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readLinksCsvDatabase(String path) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			String toplamSatirlar = "";
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
