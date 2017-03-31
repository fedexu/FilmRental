package com.filmrental.model;

import java.math.BigDecimal;
import java.sql.Date;

public class FilmRentVO {

	private int rentId=0;
	private int filmId=0;
	private  Film film=null;
	private  Date orderDate=null;
	private  Date returnDate=null;

	
	public FilmRentVO(int rentId, Film film, Date orderDate, Date returnDate) {
		this.rentId = rentId;
		this.film = film;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
	}
	
	public FilmRentVO(){
		
	}

	public int getRentId() {
		return rentId;
	}

	public Film getFilm() {
		return film;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}	
	
}
