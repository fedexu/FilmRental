package com.filmrental.dao;

import java.util.List;

import com.filmrental.model.Rents;

public interface RentsDao {
	
	/* Provides a list of Rents with all the rents still active at the current time */
	List<Rents> getAllRents();
	
	/* Provides a list of Rents with all the rents of a particular user still 
	 * active at the current time  */
	List<Rents> getRentsByUser(int id);
	
	/* Get the number of occurrences of the still unreturned film */
	int getFilmCount(int id);
	
	/* Adds a new row with the current date and time as rental time  */
	boolean rentFilm(int filmId, int userId);
	
	/* Adds a new row with the current date and time as return time  */
	boolean returnFilm(int rentId);
	
}
