package com.filmrental.dao;

import java.util.List;

import com.filmrental.model.Films;

public interface FilmsDao {
	/* Adds a new film to the database specifying if it comes from a user request
	 * a external request or the administrator [requested 1, 2, 0 respectively] */
	boolean addFilm(String title, int copies, int  requested, boolean approved);
	
	/* Provides the film with the specified id */
	Films getFilmById(int id);
	
	/* Provides a list of Films of all the films in the database */
	List<Films> getAllFilms();
	
	/* Set a suggested film as approved to be rented */
	boolean setApproved(int id, int copies);
	
	/* Set the number of copies of the film that will be possible to rent */
	boolean setCopies(int id, int copies);
	
	/* Get all the requested films not approved yet*/
	List<Films> getAllActiveRequests();

	/* Get all the films that can be rented at the moment*/
	List<Films> getAllRentableFilms();
	
	/* Check if the film si requested, not approved and with no copies left */
	boolean checkProvidable(int id);
	
	/* Marks a film as provdable by an external provider */
	boolean setProvided(int id, int copies);
	
	/* Lists all the films that are marked as providable by an external provider*/
	List<Films> getAllProvided();
}
