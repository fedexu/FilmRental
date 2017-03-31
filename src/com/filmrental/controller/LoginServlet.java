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

import com.filmrental.businesslogic.Authentication;
import com.filmrental.dao.DBUsers;
import com.filmrental.model.User;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("sei passato dal get di login");
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		if (session.getAttribute("Username") != null) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		} else {

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sei passato dal post di login");
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		String Username = (String) request.getParameter("Username");
		String U_Pass = (String) request.getParameter("U_Pass");
		Authentication aut = new Authentication();

		if (aut.matchUser(Username, U_Pass)) {
			session.setAttribute("Username", Username);
			session.setAttribute("U_Pass", U_Pass);

		} else {
			request.setAttribute("logfailure", "logfailure");
		}
		// stampo i valori ricevuti dal browser
		System.out.println(Username);
		System.out.println(U_Pass);

		// stampo i valori della session che ho appena settato
		System.out.println("Jsession ID " + sessionid);
		System.out.println("session USERNAME " + session.getAttribute("Username"));

		if (session.getAttribute("Username") != null) {
			if (aut.isAdmin(Username, U_Pass)) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login/admin/view");
				dispatcher.forward(request, response);
			} else {
			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login/user/view");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
