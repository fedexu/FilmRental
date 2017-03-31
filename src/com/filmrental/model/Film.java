package com.filmrental.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILMS")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FILM_ID")
	private int filmId;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "REGIST")
	private String regist;
	@Column(name = "EXIT_YEAR")
	private int exitYear;
	@Column(name = "QUANTITY")
	private int quantity;
	@OneToMany( mappedBy = "film")
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
