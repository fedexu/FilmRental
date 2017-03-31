package com.filmrental.model;

import java.sql.Date;

public class FilmRentVO {

	private int rentId=0;
	private  Film film=null;
	private  Date orderDate=null;
	private  Date returnDate=null;
	
	public FilmRentVO(int rentId, Film film, Date orderDate, Date returnDate) {
		this.rentId = rentId;
		this.film = film;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
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
	
	
	
}
