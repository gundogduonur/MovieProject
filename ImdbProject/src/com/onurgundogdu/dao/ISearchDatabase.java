package com.onurgundogdu.dao;

import java.util.*;

import com.onurgundogdu.dto.*;

public interface ISearchDatabase {
	public ArrayList<MoviesCsv> daoClientSearchByYear(String year);

	public ArrayList<MoviesCsv> daoClientSearchByCategory(String searchCategory);

	public ArrayList<MoviesCsv> daoClientSearchByMoviesName(String name);

	public ArrayList<MoviesCsv> daoClientSearchByArtistName(String artistName);

}
