package com.filmrental.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILMRENTED")
public class FilmRent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RENT_ID")
	private int rentId;
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	@Column(name = "RETURN_DATE")
	private Date returnDate;
	@ManyToOne()
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	@ManyToOne()
	@JoinColumn(name = "FILM_ID", nullable = false)
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
