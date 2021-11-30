package com.onurgundogdu.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.onurgundogdu.controller.Controller;
import com.onurgundogdu.dao.WriteDatabase;
import com.onurgundogdu.dto.ArtistTsv;
import com.onurgundogdu.dto.MoviesCsv;
import com.onurgundogdu.dto.MoviesTsv;
import language.*;
import com.onurgundogdu.server.Client;



public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private Language language = Language.getInstance();
	
	public void startUp() {
		List<String> listCategory = new ArrayList<String>();
		listCategory.add("Action");
		listCategory.add("Adventure");
		listCategory.add("Animation");
		listCategory.add("Children's");
		listCategory.add("Comedy");
		List<String> listYear = new ArrayList<String>();
		listYear.add("1995");
		listYear.add("1996");
		listYear.add("1997");
		listYear.add("1998");
		listYear.add("1999");
		String choose = "";
		
		while (!choose.equals("0")) {
			choose = showMenu();
			switch (choose) {
				case "1":
					System.out.println("Please enter year: ");
					choose = scanner.next();
					
					List<MoviesCsv> temp1 = Controller.getInstance()
							.daoClientSearchByYear(choose);
					System.out.println(choose);
					for (String genres : listCategory) {
						int count = 0;
						for (MoviesCsv moviesCsvDto : temp1) {
							if (moviesCsvDto.getGenres().contains(genres)) {
								if (count == 0) {
									System.out.println("\t" + genres);
								}
								count++;
								System.out.printf("\t\tTİTLE = %-40s\n ", moviesCsvDto.getTitle());
								if (count > 5) {
									break;
								}
							}
							
						}
					}
		
					choose = scanner.next();
					break;
				case "2":
					System.out.println("Which type of category?");
					choose = scanner.next();
					List<MoviesCsv> temp2 = Controller.getInstance()
							.daoClientSearchByCategory(choose);
					System.out.println(choose);
					for (String years : listYear) {
						int count = 0;
						for (MoviesCsv moviesCsvDto : temp2) {
							if (moviesCsvDto.getYears().contains(years)) {
								if (count == 0) {
									System.out.println("\t" + years);
								}
								count++;
								System.out.printf("\t\tTİTLE = %-40s\n", moviesCsvDto.getTitle());
								if (count > 5) {
									break;
								}
							}
						}
					}
			
					choose = scanner.next();
					break;
				case "3":
					Client client2 = new Client();
					System.out.println("Please enter name of movie: ");
					choose = scanner.next();
					List<MoviesCsv> temp3 = Controller.getInstance()
							.daoClientSearchByMoviesName(choose);
					MoviesTsv mov = (MoviesTsv) client2.run(choose + "&movie");
					temp3.forEach(System.out::println);
					System.out.println(mov);
					
					break;
				case "4":
					System.out.println("Please enter artist: ");
					choose = scanner.nextLine();
					Client client = new Client();
					ArtistTsv temp = (ArtistTsv) client.run(choose + "&artist");
					System.out.println(temp.getPrimaryName());
					System.out.println("\t BirthDate : " + temp.getBirthYear() + "\tDeath : " + temp.getDeathYear());
					System.out.println("\t Profession : " + temp.getPrimaryProfession().replace(",", "-"));
					System.out.println("\t KnownMovie : ");
					int count = 1;
					for (MoviesTsv temp11 : temp.getListMovie()) {
						System.out.println("\t\t " + count + "-) " + temp11.getYears() + " " + temp11.getOriginalTitle()
								+ "  " + temp11.getAverageRating());
						
						count++;
					}
					
					System.out.println();
					System.out.println();
					choose = scanner.next();
					break;
				case "5":
					WriteDatabase daoClientWriteToDatabase = new WriteDatabase();
					daoClientWriteToDatabase.writeCsvDatabase();
					choose = scanner.next();
					break;
				case "6":
					language.chanceLanguage();
					break;
				
				default:
					System.out.println("You except by entered.");
					choose = scanner.next();
					break;
			}
			
		}
		
	}
	
	private String showMenu() {
		System.out.println(translate("LANGUAGE.NAME_APP"));
		System.out.println(translate("LANGUAGE.MENU_MAIN"));
		System.out.println("--------------------------------");
		System.out.println(translate("LANGUAGE.SEARCH_YEAR"));
		System.out.println(translate("LANGUAGE.SEARCH_CATEGORY"));
		System.out.println(translate("LANGUAGE.SEARCH_MOVIES_NAME"));
		System.out.println(translate("LANGUAGE.SEARCH_ARTIST_NAME"));
		System.out.println(translate("LANGUAGE.RESET_RELOAD"));
		System.out.println(translate("LANGUAGE.CHANCE_LANGUAGE"));
		System.out.println(translate("LANGUAGE.EXIT"));
		System.out.println("--------------------------------");
		
		String choose = scanner.next();
		scanner.nextLine();
		return choose;
	}
	
	private String translate(String s) {
		return language.getLanguage().getString(s);
	}
	
}
