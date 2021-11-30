package com.onurgundogdu.dto;

import java.io.*;

public class LinkCsv extends CommonProperty implements Serializable {
	
	private static final long serialVersionUID = 964574646445151365L;
	private int imdbId;
	private int tmdbId;
	
	public LinkCsv() {
		
	}
	
	public LinkCsv(int movieId, int imdbId, int tmdbId) {
		super(movieId);
		this.imdbId = imdbId;
		this.tmdbId = tmdbId;
	}
	
	@Override
	public String toString() {
		return "LinkCsv [imdbId=" + imdbId + ", tmdbId=" + tmdbId + ", getMovieId()=" + getMovieId() + "]";
	}
	
	public int getImdbId() {
		return imdbId;
	}
	
	public void setImdbId(int imdbId) {
		this.imdbId = imdbId;
	}
	
	public int getTmdbId() {
		return tmdbId;
	}
	
	public void setTmdbId(int tmdbId) {
		this.tmdbId = tmdbId;
	}
	
}

