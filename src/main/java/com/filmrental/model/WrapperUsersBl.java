package com.filmrental.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.UsersBl;

@Service
public class WrapperUsersBl {
	
	@Autowired private UsersBl usrBl;
	
	public WrapperUsersBl(){}
	
	/*Wrapping the showUser output to be used with JSONS*/
	public String showUser(String u){
		ModelAndView res = usrBl.showUser(u);
		Map map = res.getModel();
		List<Rents> filmsOwned = (List<Rents>) map.get("filmsOwned");
		String jsonString = "["+filmsOwned.toString();
		
		if(filmsOwned != null && filmsOwned.size() < 3){ //TODO parameter
			List<Films> filmsAvailable = (List<Films>) map.get("filmsAvailable");
			jsonString = jsonString +"," + filmsAvailable.toString() + "]";
		}
		else jsonString = jsonString + "]";
		
		return jsonString;
	}
	
	/* Invokes the dao to try renting a film*/
	public void rentFilm(int filmId){
		usrBl.rentFilm(filmId);
	}
	
	/* Invokes the dao to return a film */
	public void returnFilm(int id) {
		usrBl.returnFilm(id);
	}

	/*Invokes the dao to insert a new film request*/
	public void addFilmRequest(String filmTitle) {
		usrBl.addFilmRequest(filmTitle);
	}
}
