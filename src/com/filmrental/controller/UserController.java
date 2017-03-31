package com.filmrental.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.filmrental.businesslogic.Store;
import com.filmrental.dao.DBFilms;
import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.FilmRequest;
import com.filmrental.model.User;

@Controller
public class UserController {

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/login/user", method = RequestMethod.GET)
	public String getUserController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			addAllFilmRentedOnJSP(model);
			return "user";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/login/user/returnfilm", method = RequestMethod.GET)
	public String getReturnFilmController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			addAllFilmRentedOnJSP(model);
			return "user";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/login/user/rentfilm", method = RequestMethod.GET)
	public String getRentFilmController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			addAllFilmRentedOnJSP(model);
			return "user";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/login/user/addrequest", method = RequestMethod.GET)
	public String getRequestController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			addAllFilmRentedOnJSP(model);
			return "user";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/login/user/returnfilm", method = RequestMethod.POST)
	public String returnAFilmByUser(@ModelAttribute("returnfilm") FilmRent filmreturned, ModelMap model) {
		Store store = new Store();

		User user = store.setUserInStore(userSession.getUsername());
		String rent_id = Integer.valueOf(filmreturned.getRentId()).toString();
		store.returnFilmRentedByUser(user, rent_id);
		addAllFilmRentedOnJSP(model);

		return "user";
	}

	@RequestMapping(value = "/login/user/rentfilm", method = RequestMethod.POST)
	public String rentAFilmByUser(@ModelAttribute("rentFilm") Film rentfilm, ModelMap model) {
		Store store = new Store();

		User user = store.setUserInStore(userSession.getUsername());
		store.addFilmRentedByUser(user, rentfilm);
		addAllFilmRentedOnJSP(model);

		return "user";
	}

	@RequestMapping(value = "/login/user/addrequest", method = RequestMethod.POST)
	public String addrequestByUser(@ModelAttribute("request") FilmRequest frequest, ModelMap model) {
		Store store = new Store();

		User user = store.setUserInStore(userSession.getUsername());
		String title = frequest.getTitle();
		String regist = frequest.getRegist();
		String exitYear = Integer.valueOf(frequest.getExitYear()).toString();

		if (title != "" && regist != "" && exitYear != "" && exitYear.matches("[0-9]+")) {
			store.addRequestByUser(user, title, regist, exitYear);
			model.addAttribute("request", frequest);
			model.addAttribute("requestdone", "Your suggestion has been sent.");
		} else {
			model.addAttribute("requestfailure", "Please insert all fields before submit a request.");

		}

		addAllFilmRentedOnJSP(model);
		return "user";

	}

	private void addAllFilmRentedOnJSP(ModelMap model) {
		Store store = new Store();
		DBFilms f = new DBFilms();

		model.addAttribute("addFilmRent", new Film());
		model.addAttribute("returnFilm", new FilmRent());
		model.addAttribute("rentFilm", new Film());
		model.addAttribute("request", new FilmRequest());

		// recupero tutte le info dell'utente loggato e li
		// passo
		// alla
		// jsp user
		User user = store.setUserInStore(userSession.getUsername());

		// stampo lo storico dei filmrented by this user
		List<FilmRent> listrented = store.filmRentedbyUser(user);

		// stampo i film noleggiabili dallo store
		List<Film> films = store.filmRentable();

		// aggiorno la lista dei film disponibili alla quantità disponibile
		BigDecimal[] number = f.getNumberOfFilmRentedCopies(films);
		Integer[] count = new Integer[number.length];
		for (int i = 0; i < number.length; i++) {
			count[i] = films.get(i).getQuantity() - number[i].intValueExact();
		}

		// passo gli attributi alla jsp
		model.addAttribute("count", count);
		model.addAttribute("films", films);
		model.addAttribute("listrented", listrented);

	}
}
