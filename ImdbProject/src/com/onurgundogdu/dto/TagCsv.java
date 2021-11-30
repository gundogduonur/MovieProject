package com.onurgundogdu.dto;

import java.io.*;
import java.util.*;



public class TagCsv extends CommonProperty implements Serializable {
	
	private static final long serialVersionUID = 2253889326270774904L;
	
	private int userId;
	private String tag;
	private Date timestamp;
	
	public TagCsv() {
	}
	
	public TagCsv(int movieId, int userId, String tag, Date timestamp) {
		super(movieId);
		this.userId = userId;
		this.tag = tag;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "TagCsv [userId=" + userId + ", tag=" + tag + ", timestamp=" + timestamp + ", getMovieId()="
				+ getMovieId() + "]";
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}

