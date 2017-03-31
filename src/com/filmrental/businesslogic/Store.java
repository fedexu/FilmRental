package com.filmrental.businesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.filmrental.dao.DBFilmRent;
import com.filmrental.dao.DBFilmRequest;
import com.filmrental.dao.DBFilms;
import com.filmrental.dao.DBUsers;
import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.FilmRequest;
import com.filmrental.model.User;

public class Store {
	public Store() {
	}

	public List<Film> filmRentable()  {
		List<Film> list = new ArrayList<Film>();
		DBFilms film = new DBFilms();
		list = film.selectAllFilm();
		return list;
	}

	public List<FilmRent> filmRentedbyUser(User user)  {
		DBFilmRent fr = new DBFilmRent();
		List<FilmRent> listrented = fr.selectFilmsRentByUserId(user);
		return listrented;
	}

	public User setUserInStore(String Username)  {
		User user = new User();
		DBUsers us = new DBUsers();
		user = us.selectUserDetails(Username);
		return user;
	}

	public List<FilmRent> addFilmRentedByUser(User user, String[] controller) {
	
		DBFilmRent fr = new DBFilmRent();
		List<Film> list = filmRentable();
		List<FilmRent> listrented = fr.selectFilmsRentByUserId(user);
		for (int i = 0; i < list.size(); i++) {
			if (controller[i] != null) {
				Film film = new Film();
				fr = new DBFilmRent();
				film = list.get(i);
				fr.addFilmRent(film, user);
				listrented = fr.selectFilmsRentByUserId(user);
			}
		}
		return listrented;
	}
	
	public List<FilmRent> addFilmRentedByUser(User user,Film film) {
		
		DBFilmRent fr = new DBFilmRent();
		fr.addFilmRent(film, user);
		List<FilmRent> listrented = fr.selectFilmsRentByUserId(user);
		return listrented;
	}

	public List<FilmRent> returnFilmRentedByUser(User user,String rent_Id){
		DBFilmRent fr = new DBFilmRent();
		List<FilmRent> listrented = fr.selectFilmsRentByUserId(user);
		int rentid = Integer.parseInt(rent_Id);
		fr.returnFilmRent(rentid);
		listrented = fr.selectFilmsRentByUserId(user);
		return listrented;
	}
	
	public void addRequestByUser(User user,String Title,String Regist,String Exit_Year){
		DBFilmRequest req = new DBFilmRequest();
		FilmRequest filmreq = new FilmRequest();
		filmreq.setUserId(user.getUserId());
		filmreq.setTitle(Title);
		filmreq.setRegist(Regist);
		filmreq.setExitYear(Integer.parseInt(Exit_Year));
		req.addFilmRequest(filmreq);		
	}
	
	public void addFilmByAdmin(String Title,String Regist,String Exit_Year,String Quantity){
		Film film = new Film();
		DBFilms f = new DBFilms();
		film.setTitle(Title);
		film.setRegist(Regist);
		film.setExitYear(Integer.parseInt(Exit_Year));
		film.setQuantity(Integer.parseInt(Quantity));
		f.addFilm(film);
	}
	
	public Boolean removeFilmByAdmin(String film_id){
		DBFilms f = new DBFilms();
		Boolean ris = false;
		int num = f.getNumberOfThisFilmRentedCopies(film_id).intValueExact();
		if(num==0){
		f.removeFilm(film_id);
		ris= true;
		}
		return ris;
	}
	
	public List<FilmRequest> selectAllRequest(){
		List<FilmRequest> listr;
		DBFilmRequest fr = new DBFilmRequest();
		listr = fr.selectAllRequest();
		return listr;
	}
}
