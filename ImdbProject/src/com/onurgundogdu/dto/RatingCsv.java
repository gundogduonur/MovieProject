package com.onurgundogdu.dto;

import java.io.*;
import java.util.*;



public class RatingCsv extends CommonProperty implements Serializable {

	private static final long serialVersionUID = -42424089873325549L;

	private int userId;
	private double rating;
	private Date timestamp;

	public RatingCsv() {

	}

	public RatingCsv(int movieId, int userId, double rating, Date timestamp) {
		super(movieId);
		this.userId = userId;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "RatingCsv [userId=" + userId + ", rating=" + rating + ", timestamp=" + timestamp + ", getMovieId()="
				+ getMovieId() + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
