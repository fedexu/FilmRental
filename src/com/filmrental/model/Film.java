package com.filmrental.model;

import java.util.List;

public class Film {
	private int filmId;
	private String title;
	private String regist;
	private int exitYear;
	private int quantity;
	private List<FilmRent> filmRented;

	public Film() {
		filmId = 0;
		title = null;
		regist = null;
		exitYear = 0;
		quantity = 0;
	}

	// set e get di filmId
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getFilmId() {
		return this.filmId;
	}

	// set get title
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// set get regist
	public void setRegist(String regist) {
		this.regist = regist;
	}

	public String getRegist() {
		return this.regist;
	}

	// set e get di exitYear
	public void setExitYear(int exitYear) {
		this.exitYear = exitYear;
	}

	public int getExitYear() {
		return this.exitYear;
	}

	// set e get di quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public List<FilmRent> getFilmRented() {
		return filmRented;
	}

	public void setFilmRented(List<FilmRent> filmRented) {
		this.filmRented = filmRented;
	}
}
