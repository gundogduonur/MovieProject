package com.onurgundogdu.dto;

import java.io.*;



public class MoviesCsv extends CommonProperty implements Serializable {
	
	private static final long serialVersionUID = 7264668196007694963L;
	
	private String title;
	private String genres;
	private double maxRating;
	private double minRating;
	private double averageRating;
	private String years;
	
	public MoviesCsv() {
		
	}
	
	public MoviesCsv(int movieId, String title, String genres) {
		super(movieId);
		this.title = title;
		this.genres = genres;
	}
	
	public String toString() {
		return "title=" + title + " genres=" + genres + ", maxRating=" + maxRating + ", minRating=" + minRating
				+ ", averageRating=" + averageRating + "]";
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public String getYears() {
		return years;
	}
	
	public void setYears(String years) {
		this.years = years;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenres() {
		return genres;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	public double getMaxRating() {
		return maxRating;
	}
	
	public void setMaxRating(double maxRating) {
		this.maxRating = maxRating;
	}
	
	public double getMinRating() {
		return minRating;
	}
	
	public void setMinRating(double minRating) {
		this.minRating = minRating;
	}
	
	public double getAverageRating() {
		return averageRating;
	}
	
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

}
