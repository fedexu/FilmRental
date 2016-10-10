package com.filmrental.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.FilmsBl;
import com.filmrental.bl.UsersBl;
import com.filmrental.model.Users;

@Controller
@RequestMapping("/")
public class Control {
	//autowired functions from BI
	@Autowired private UsersBl usersBl;
	//@Autowired private RentsBl rentsBl;
	@Autowired private FilmsBl filmsBl;
	
	/*@RequestMapping(value = "/clientView", method = RequestMethod.GET)
	public String listAll(Model model) {
	    model.addAttribute("cities", rentsBl.getRented());
	    return "client";
	}*/
	
	/*@RequestMapping(value = "/clientView", method = RequestMethod.GET)
	public String listAll(Model model) {
	   // model.addAttribute("cities", cityOp.getCityList());
	    return "admin";
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(){
		ModelAndView m = new ModelAndView("login");
		return m;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView logIn(@ModelAttribute Users user) {
		
		ModelAndView m = new ModelAndView();
		m = usersBl.loginUser(user);
		return m;
	}
	
}
