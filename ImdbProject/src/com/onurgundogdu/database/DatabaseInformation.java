package com.onurgundogdu.database;

public class DatabaseInformation {
	private String url;
	private String userName;
	private String password;
	private String forNameData;
	private String url2;
	
	public DatabaseInformation() {
		this.url = "jdbc:postgresql://localhost:5432/maratonaratatil";
		this.url2 = "jdbc:postgresql://localhost:5432/";
		
		this.userName = "onurgundogdu";
		this.password = "";
		this.forNameData = "org.postgresql.Driver";
		
	}
		
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getForNameData() {
		return forNameData;
	}
	
	public void setForNameData(String forNameData) {
		this.forNameData = forNameData;
	}
	
	public String getUrl2() {
		return url2;
	}
	
	public void setUrl2(String url2) {
		this.url2 = url2;
	}
	
}
