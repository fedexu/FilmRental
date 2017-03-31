package com.filmrental.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.filmrental.businesslogic.Authentication;
import com.filmrental.dao.DBUsers;
import com.filmrental.model.User;
import com.filmrental.model_view.UserView;

@Controller
@RequestMapping("/login")
@Scope("session")
public class LoginController {

	@Autowired
	private UserSession userSession;

	@RequestMapping(method = RequestMethod.GET)
	public String getLoginView(ModelMap model) {
		model.addAttribute("userlogin", new UserView());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userlogin") UserView userview, ModelMap model) {

		String ris = "login";

		Authentication aut = new Authentication();

		if (aut.matchUser(userview.getUsername(), userview.getPassword())) {
			System.out.println("login effettuato devi aggiungerlo in sessione");
			DBUsers us = new DBUsers();
			User user = us.selectUserDetails(userview.getUsername());
			userSession.setUserId(user.getUserId());
			userSession.setUsername(user.getUsername());

			System.out.println("usersession user id " + userSession.getUserId());
			System.out.println("usersession username " + userSession.getUsername());

			if (aut.isAdmin(userview.getUsername(), userview.getPassword())) {
				return "redirect:/login/admin";
			} else {
				return "redirect:/login/user";
			}

		} else {
			System.out.println("login failure");
			model.addAttribute("loginfailure", "Invalid Username or Password. Please retry.");
		}

		return ris;
	}
}
