package com.filmrental.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.control.UserSession;
import com.filmrental.dao.FilmsDao;
import com.filmrental.dao.RentsDao;
import com.filmrental.model.Films;
import com.filmrental.model.Rents;

@Service
public class AdminBl{
	@Autowired private UserSession username;
	
	@Autowired private RentsDao rentsDao;
	@Autowired private FilmsDao filmsDao;
	
	
	/* Fetches and collects all the information useful to render a view for the 
	 * administrator homepage by invoking the appropriate DAO operations and collecting the
	 * results into a ModelAndView structure that can be directly displayed by the controller*/
	public ModelAndView showAdmin(String u){
		ModelAndView m = new ModelAndView("admin");
		m.addObject("userName", username.getUsername());
		List<Rents> rentedFilms = rentsDao.getAllRents();
		m.addObject("currentRents", rentedFilms);
		List<Films> requests = filmsDao.getAllActiveRequests();
		m.addObject("suggestedTitles", requests);
		List<Films> provided = filmsDao.getAllProvided();
		m.addObject("provided", provided);
		return m;
	}
	
	/* Perform the adding of a new film to the db of all available films */
	public void addToCollection(String filmTitle, int quantity) {
		filmsDao.addFilm(filmTitle, quantity, 0, true); //TODO parameter
	}
	
	/* Adds a film to the db from the list of requests by the users */
	public void addFromRequests(int id, int quantity){
		filmsDao.setApproved(id, quantity);
	}
	

}
