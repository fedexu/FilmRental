package com.filmrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.filmrental.businesslogic.Store;
import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.FilmRequest;
import com.filmrental.model.User;
import com.filmrental.model_view.FilmView;
import com.filmrental.model_view.RequestView;

@Controller
public class AdminController {

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/login/admin", method = RequestMethod.GET)
	public String getAdminController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			System.out.println("sei passato dalla get della AdminController in Session");

			addAllFilmsOnJSP(model);

			return "admin";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login/admin/addfilm", method = RequestMethod.GET)
	public String getAddFilmController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			System.out.println("sei passato dalla get della AdminController in Session");

			addAllFilmsOnJSP(model);

			return "admin";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login/admin/removeFilm", method = RequestMethod.GET)
	public String getRemoveFilmController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			System.out.println("sei passato dalla get della AdminController in Session");

			addAllFilmsOnJSP(model);

			return "admin";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login/admin/addrequest", method = RequestMethod.GET)
	public String getAddRequestController(ModelMap model) {
		if (userSession.getUserId() != 0) {
			System.out.println("sei passato dalla get della AdminController in Session");

			addAllFilmsOnJSP(model);

			return "admin";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/login/admin/addfilm", method = RequestMethod.POST)
	public String addFilmtByAdmin(@ModelAttribute("addFilm") FilmView addFilm, ModelMap model) {

		Store store = new Store();
		String title = addFilm.getTitle();
		String regist = addFilm.getRegist();
		String exitYear = addFilm.getExitYear();
		String quantity = addFilm.getQuantity();

		if (title != null) {
			if (addFilm.getTitle() != "" && addFilm.getRegist() != "" && exitYear != "" && quantity != ""
					&& exitYear.matches("[0-9]+") && quantity.matches("[0-9]+") && quantity != "0") {

				store.addFilmByAdmin(title, regist, exitYear, quantity);

			} else {
				model.addAttribute("ErrorRequest", "Please insert correct fields before adding a film.");
			}
		}
		addAllFilmsOnJSP(model);
		return "admin";
	}

	@RequestMapping(value = "/login/admin/addrequest", method = RequestMethod.POST)
	public String addRequesttByAdmin(@ModelAttribute("addrequest") RequestView addrequest, ModelMap model) {

		Store store = new Store();
		String title = addrequest.getTitle();
		String regist = addrequest.getRegist();
		String exitYearSt = Integer.valueOf(addrequest.getExitYear()).toString();
		String quantitySt = Integer.valueOf(addrequest.getQuantity()).toString();
		int quantity = addrequest.getQuantity();
		if (title != "" && regist != "" && exitYearSt != "" && quantitySt != "" && exitYearSt.matches("[0-9]+")
				&& quantitySt.matches("[0-9]+") && quantity != 0) {
			store.addFilmByAdmin(title, regist, exitYearSt, quantitySt);

		} else {
			model.addAttribute("ErrorRequest2", "Please insert all fields before adding a film.");
			model.addAttribute("ErrorAdd2", "Please insert a correct quantity before adding a film.");
		}

		addAllFilmsOnJSP(model);
		return "admin";
	}

	@RequestMapping(value = "/login/admin/removeFilm", method = RequestMethod.POST)
	public String removeFilmByAdmin(@ModelAttribute("removeFilm") Film removeFilm, ModelMap model) {

		Store store = new Store();
		String filmId = Integer.valueOf(removeFilm.getFilmId()).toString();

		// rimuove un film dalla collection dei film rentable
		if (removeFilm.getFilmId() != 0) {
			Boolean ris = store.removeFilmByAdmin(filmId);

			if (ris == false) {
				model.addAttribute("ErrorDelete",
						"Some copies of this film are rented. Return all copies from users before delete!");
			}
		}
		addAllFilmsOnJSP(model);
		return "admin";

	}

	private void addAllFilmsOnJSP(ModelMap model) {
		Store store = new Store();

		model.addAttribute("addFilm", new FilmView());
		model.addAttribute("removeFilm", new Film());
		model.addAttribute("addrequest", new RequestView());

		// recupero tutte le info dell'utente admin loggato e li
		// passo
		// alla
		// jsp admin
		User user = store.setUserInStore(userSession.getUsername());

		// stampo lo storico dei filmrented by this user
		List<FilmRent> listrented = store.filmRentedbyUser(user);

		// stampo lo storico dei film request by all user
		List<FilmRequest> allrequest = store.selectAllRequest();

		// stampo i film noleggiabili dallo store
		List<Film> films = store.filmRentable();

		model.addAttribute("films", films);
		model.addAttribute("listrented", listrented);
		model.addAttribute("filmrequest", allrequest);
	}
}
