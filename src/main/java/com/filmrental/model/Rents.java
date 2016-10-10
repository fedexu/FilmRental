package com.filmrental.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rents")
public class Rents {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="UserId")
	private int userId;
	
	@Column(name="FilmId")
	private int filmId;
	
	/*The @Temporal annotation tells Hibernate if it should use a java.sql.Date or a java.sql.Timestamp 
	 * to store the date read from the database. Both extend the java.util.Date class,
	 * but java.sql.Date doesn't hold any time information: only the date.*/
	@Column(name = "Rented", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date rented;
	
	@Column(name = "Returned", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date returned;
	
	@ManyToOne
	@JoinColumn(name="filmId", insertable=false, updatable=false, 
			nullable=false)
	private Films film;
	
	@ManyToOne
	@JoinColumn(name="userId", insertable=false, updatable=false, 
			nullable=false)
	private Users associatedUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public Date getRented() {
		return rented;
	}

	public void setRented(Date rented) {
		this.rented = rented;
	}

	public Date getReturned() {
		return returned;
	}

	public void setReturned(Date returned) {
		this.returned = returned;
	}

	public Films getFilm() {
		return film;
	}

	public void setFilm(Films film) {
		this.film = film;
	}

	public Users getUser() {
		return associatedUser;
	}

	public void setUser(Users user) {
		this.associatedUser = user;
	}
}
