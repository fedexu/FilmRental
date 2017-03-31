package com.filmrental.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.filmrental.businesslogic.Store;
import com.filmrental.dao.DBFilmRent;
import com.filmrental.dao.DBFilms;
import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.FilmRequest;
import com.filmrental.model.User;

public class AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("sei passato dal get di admin servlet");
		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			doPost(request, response);
		} else {
			request.setAttribute("error", "error");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("sei passata dal post della admin servlet");
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		String Username = (String) session.getAttribute("Username");

		// controllo se è stato premuto un logout
		String logout = request.getParameter("logout");
		if (logout != null && logout.equals("logout")) {
			session.invalidate();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		} else {

			// controllo se è stato effettuato il login
			if (session.getAttribute("Username") != null) {
				Store store = new Store();
				DBFilmRent fr = new DBFilmRent();
				DBFilms f = new DBFilms();

				try {
					// recupero tutte le info dell'utente admin loggato e li
					// passo
					// alla
					// jsp admin
					User user = store.setUserInStore(Username);
					request.setAttribute("User", user);

					// stampo lo storico dei filmrented by this user
					List<FilmRent> listrented = store.filmRentedbyUser(user);

					// stampo lo storico dei film request by all user
					List<FilmRequest> allrequest = store.selectAllRequest();

					// aggiunge un film alla collection dei film rentable o
					// aggiunge un film suggerito alla collection dei film
					// rentable
					if (request.getParameter("addfilm") != null) {
						if (request.getParameter("Add_Title") != "" && request.getParameter("Add_Regist") != ""
								&& request.getParameter("Add_Exit_Year") != ""
								&& request.getParameter("Add_Quantity") != ""
								&& request.getParameter("Add_Exit_Year").matches("[0-9]+")
								&& request.getParameter("Add_Quantity").matches("[0-9]+")) {
							String Title = request.getParameter("Add_Title");
							String Regist = request.getParameter("Add_Regist");
							String Exit_Year = request.getParameter("Add_Exit_Year");
							String Quantity = request.getParameter("Add_Quantity");
							store.addFilmByAdmin(Title, Regist, Exit_Year, Quantity);
						} else {
							request.setAttribute("ErrorRequest", "Please insert all fields before adding a film.");
							request.setAttribute("ErrorAdd", "Please insert a correct quantity before adding a film.");
						}
					}
					// rimuove un film dalla collection dei film rentable
					if (request.getParameter("deletefilm") != null) {
						String film_id = request.getParameter("Film_Id");
						Boolean ris = store.removeFilmByAdmin(film_id);
						if (ris == false) {
							request.setAttribute("ErrorDelete",
									"Some copies of this film are rented. Return all copies from users before delete!");
						}
					}

					// stampo i film noleggiabili dallo store
					List<Film> list = store.filmRentable();

					// passo alla jsp i film disponibili e i film noleggiati,
					// aggiornati e i film richiesti
					request.setAttribute("films", list);
					request.setAttribute("ListRented", listrented);
					request.setAttribute("allrequest", allrequest);

				} catch (NamingException | SQLException e) {
					e.printStackTrace();
				}

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp");
				dispatcher.forward(request, response);

			}
		}
	}
}
