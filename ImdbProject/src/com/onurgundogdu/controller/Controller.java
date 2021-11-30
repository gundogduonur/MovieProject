package com.onurgundogdu.controller;

import java.util.*;

import com.onurgundogdu.dao.ISearchDatabase;
import com.onurgundogdu.dao.SearchDatabase;
import com.onurgundogdu.dto.MoviesCsv;
import com.onurgundogdu.dto.MoviesPack;

import importcsv.IClient;

public class Controller implements ISearchDatabase {
	private static Controller instance;
	private SearchDatabase dao;

	private Controller(){
		dao = new SearchDatabase();
	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;

	}


	public ArrayList<MoviesCsv> daoClientSearchByYear(String year) {
		return dao.daoClientSearchByYear(year);
	}

	public ArrayList<MoviesCsv> daoClientSearchByCategory(String searchCategory) {
		return dao.daoClientSearchByCategory(searchCategory);
	}


	public ArrayList<MoviesCsv> daoClientSearchByMoviesName(String name) {
		return dao.daoClientSearchByMoviesName(name);
	}

	public ArrayList<MoviesCsv> daoClientSearchByArtistName(String artistName) {
		return dao.daoClientSearchByArtistName(artistName);
	}

}
