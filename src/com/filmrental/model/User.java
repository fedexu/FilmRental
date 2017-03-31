package com.filmrental.model;

import java.util.List;

public class User {
	private int userId;
	private String username;
	private String pass;
	private String firstName;
	private String lastName;
	private List<FilmRent> filmRented;
	private List<FilmRequest> filmRequest;

	public User() {
		userId = 0;
		username = null;
		pass = null;
		firstName = null;
		lastName = null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<FilmRent> getFilmRented() {
		return filmRented;
	}

	public void setFilmRented(List<FilmRent> filmRented) {
		this.filmRented = filmRented;
	}

	public List<FilmRequest> getFilmRequest() {
		return filmRequest;
	}

	public void setFilmRequest(List<FilmRequest> filmRequest) {
		this.filmRequest = filmRequest;
	}

}
