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
public class AdminBl {
	@Autowired private UserSession username;
	
	@Autowired private RentsDao rentsDao;
	@Autowired private FilmsDao filmsDao;
	
	public ModelAndView showAdmin(String u){
		ModelAndView m = new ModelAndView("admin");
		m.addObject("userName", username.getUsername());
		List<Rents> rentedFilms = rentsDao.getAllRents();
		m.addObject("currentRents", rentedFilms);
		List<Films> requests = filmsDao.getAllActiveRequests();
		m.addObject("suggestedTitles", requests);
		return m;
	}

	public void addToCollection(String filmTitle, int quantity) {
		filmsDao.addFilm(filmTitle, quantity, 0, true); //TODO parameter
	}

}
