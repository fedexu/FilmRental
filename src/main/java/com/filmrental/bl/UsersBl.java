package com.filmrental.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.model.Films;
import com.filmrental.model.Rents;
import com.filmrental.control.UserSession;
import com.filmrental.dao.FilmsDao;
import com.filmrental.dao.RentsDao;

@Service
public class UsersBl {
	@Autowired private UserSession userSession;

	@Autowired private RentsDao rentsDao;
	@Autowired private FilmsDao filmsDao;
	
	/* Gets all the required tables to show a view for the simple user */
	public ModelAndView showUser(String u){
		ModelAndView m = new ModelAndView("user");
		m.addObject("userName", userSession.getUsername());
		List<Rents> filmsOwned = rentsDao.getRentsByUser(userSession.getId());
		m.addObject("filmsOwned", filmsOwned);

		if(filmsOwned != null && filmsOwned.size() < 3){ //TODO parameter
			List<Films>  filmsAvailable = filmsDao.getAllRentableFilms();
			m.addObject("filmsAvailable", filmsAvailable);
		}
		return m;
	}
	
	public void returnFilm(int id) {
		rentsDao.returnFilm(id);
		System.out.println("BL");
		
	}
	
	/* Invokes the dao to try renting a film*/
	public void rentFilm(int filmId){
		rentsDao.rentFilm(filmId, userSession.getId());
	}

	/*Invokes the dao to insert a new film request*/
	public void addFilmRequest(String filmTitle) {
		filmsDao.addFilm(filmTitle, 0, 1, false); //TODO parameter
	}
}
