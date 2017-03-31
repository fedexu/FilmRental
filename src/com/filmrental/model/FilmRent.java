package com.filmrental.model;

import java.sql.Date;
import java.time.LocalDate;

public class FilmRent {

	private int rentId;
	private Date orderDate;
	private Date returnDate;
	private User user;
	private Film film;

	public FilmRent() {

	}

	// set get rentId
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public int getRentId() {
		return this.rentId;
	}

	// set get orderDate
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	// set get returnDate
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
