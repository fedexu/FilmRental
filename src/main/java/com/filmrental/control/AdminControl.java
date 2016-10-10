package com.filmrental.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.AdminBl;

@Controller
@RequestMapping("/login/admin")

public class AdminControl {
	@Autowired private UserSession username;
	
	@Autowired private AdminBl adminBl;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView displayAdminView(){
		if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		ModelAndView m = adminBl.showAdmin(username.getUsername());
		return m;
	}
	
	@RequestMapping(value = "/addToCollection", method = RequestMethod.POST)
	public String addToCollection(String filmTitle, int quantity){
		if(username.getUsername() == null) return "redirect:/login";
		System.out.println(filmTitle);
		adminBl.addToCollection(filmTitle, quantity);
		System.out.println(filmTitle);
		return "redirect:/login/admin/view";
	}
}
