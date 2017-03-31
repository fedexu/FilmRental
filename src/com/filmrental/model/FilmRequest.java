package com.filmrental.model;

public class FilmRequest {

	private int User_Id;
	private String Title;
	private String Regist;
	private int Exit_Year;
	private int Request_Id;

	public FilmRequest() {
		User_Id = 0;
		Title = null;
		Regist = null;
		Exit_Year = 0;
		Request_Id = 0;
	}

	// set e get di User_Id
	public void setUser_Id(int User_Id) {
		this.User_Id = User_Id;
	}

	public int getUser_Id() {
		return this.User_Id;
	}

	// set get Title
	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getTitle() {
		return this.Title;
	}

	// set get Regist
	public void setRegist(String Regist) {
		this.Regist = Regist;
	}

	public String getRegist() {
		return this.Regist;
	}

	// set e get di Exit_Year
	public void setExit_Year(int Exit_Year) {
		this.Exit_Year = Exit_Year;
	}

	public int getExit_Year() {
		return this.Exit_Year;
	}
	
	// set e get di Request_Id
	public void setRequest_Id(int Request_Id) {
		this.Request_Id = Request_Id;
	}

	public int getRequest_Id() {
		return this.Request_Id;
	}
	
}
