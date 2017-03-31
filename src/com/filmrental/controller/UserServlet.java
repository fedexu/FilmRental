package com.filmrental.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.filmrental.dao.DBUsers;
import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;
import com.filmrental.model.User;

public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("sei passato dal get di user servlet");
		HttpSession session = request.getSession();
		if (session.getAttribute("Username") != null) {

			String sessionid = session.getId();
			request.setAttribute("JSESSIONID", sessionid);
			doPost(request, response);

		} else {
			System.out.println("volevi accedere alla pagina user senza usare la login");
			request.setAttribute("error", "error");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("sei passata dal post della user servlet");
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		String Username = (String) session.getAttribute("Username");

		// controllo se è stato premuto un logout
		String logout = request.getParameter("logout");
		if (logout != null && logout.equals("logout")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}

		// controllo se è stato effettuato il login
		if (session.getAttribute("Username") != null) {
			Store store = new Store();
			DBFilmRent fr = new DBFilmRent();
			DBFilms f = new DBFilms();

			try {
				// recupero tutte le info dell'utente loggato e li passo alla
				// jsp
				User user = store.setUserInStore(Username);
				request.setAttribute("User", user);
				// stampo i film noleggiabili dallo store
				List<Film> list = store.filmRentable();

				// controllo rent in store
				if (request.getParameter("rentfilm") != null) {
					String[] controller = new String[list.size()];
					for (int i = 0; i < list.size(); i++) {
						controller[i] = request.getParameter("rentfilm" + i);
					}
					store.addFilmRentedByUser(user, controller);
				}

				// stampo lo storico dei filmrented by this user
				List<FilmRent> listrented = store.filmRentedbyUser(user);

				// controllo return in store
				if (request.getParameter("returnfilm") != null) {
					String rent_id = request.getParameter("Rent_Id");
					listrented = store.returnFilmRentedByUser(user, rent_id);
				}

				// controllo request by this user e la aggiungo
				if (request.getParameter("Request") != null) {
					
					if (request.getParameter("Req_Title") != "" && request.getParameter("Req_Regist") != ""
							&& request.getParameter("Req_Exit_Year") != ""
							&& request.getParameter("Req_Exit_Year").matches("[0-9]+")) {
						System.out.println("sei passata dal request con parametri input non nulli");
						String Title = request.getParameter("Req_Title");
						String Regist = request.getParameter("Req_Regist");
						String Exit_Year = request.getParameter("Req_Exit_Year");
						store.addRequestByUser(user, Title, Regist, Exit_Year);
						request.setAttribute("AddedRequest", "Your suggestion has been sent.");
					} else {
						request.setAttribute("ErrorRequest", "Please insert all fields before submit a request.");
					}
				}

				// aggiorno la lista dei film disponibili alla quantità
				// disponibile
				Integer[] number = f.getNumberOfFilmRentedCopies(list);

				// passo alla jsp i film disponibili e i film noleggiati,
				// aggiornati
				request.setAttribute("films", list);
				request.setAttribute("ListRented", listrented);
				request.setAttribute("number", number);

			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/user.jsp");
			dispatcher.forward(request, response);
		} else

		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
