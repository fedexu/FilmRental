package com.filmrental.model;

import java.sql.Date;
import java.time.LocalDate;

public class FilmRent {
	private int Rent_Id;
	private int User_Id;
	private String Username;
	private int Film_Id;
	private String Title;
	private Date Order_Date;
	private Date Return_Date;

	public FilmRent() {
		Rent_Id = 0;
		User_Id = 0;
		Username = null;
		Film_Id = 0;
		Title = null;
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

	// set get User_Id
	public void setUser_Id(int User_id) {
		this.User_Id = User_id;
	}

	public int getUser_Id() {
		return this.User_Id;
	}

	// set get Username
	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getUsername() {
		return this.Username;
	}

	// set get Rent_ID
	public void setRent_Id(int Rent_Id) {
		this.Rent_Id = Rent_Id;
	}

	public int getRent_Id() {
		return this.Rent_Id;
	}

	// set get Order_Date
	public void setOrder_Date(Date Order_Date) {
		this.Order_Date = Order_Date;
	}

	public Date getOrder_Date() {
		return this.Order_Date;
	}
	// set get Return_Date
	public void setReturn_Date(Date Return_Date) {
		this.Return_Date = Return_Date;
	}

	public Date getReturn_Date() {
		return this.Return_Date;
	}

}
