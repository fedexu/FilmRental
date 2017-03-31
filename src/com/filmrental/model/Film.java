package com.filmrental.model;

public class Film {
	private int Film_Id;
	private String Title;
	private String Regist;
	private int Exit_Year;
	private int Quantity;

	public Film() {
		Film_Id = 0;
		Title = null;
		Regist = null;
		Exit_Year = 0;
		Quantity = 0;
	}

	// set e get di Film_Id
	public void setFilm_Id(int Film_Id) {
		this.Film_Id = Film_Id;
	}

	public int getFilm_Id() {
		return this.Film_Id;
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

	// set e get di Quantity
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	public int getQuantity() {
		return this.Quantity;
	}
}
