package com.filmrental.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.LoginBl;
import com.filmrental.model.Users;

@Controller
@Scope("session")
public class LoginControl {	
	@Autowired private UserSession username;
	@Autowired private LoginBl loginBl;
	
	/* Shows a basic login interface */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(){
		ModelAndView m = new ModelAndView("login");
		m.addObject("username", username.getUsername());
		return m;
	}
	
	/* Gets the user-name and redirects the user to his view*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView logIn(@ModelAttribute Users user) {
		String checkResult = loginBl.checkUserName(user.getUsername());
		ModelAndView m = new ModelAndView(checkResult);
		m.addObject("thought", user.getUsername());
		return m;
	}	
}
