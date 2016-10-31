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
	
	/* Maps the requests to view the administrator homepage*/
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView displayAdminView(){
		if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		ModelAndView m = adminBl.showAdmin(username.getUsername());
		return m;
	}
	
	/* Maps the request to add a new film to the db*/
	@RequestMapping(value = "/addToCollection", method = RequestMethod.POST)
	public String addToCollection(String filmTitle, int quantity){
		if(username.getUsername() == null) return "redirect:/login";
		adminBl.addToCollection(filmTitle, quantity);
		return "redirect:/login/admin/view";
	}
	
	/* Maps the request to add a new film to the db from the list of films
	 * proposed by the users or provided by the */
	@RequestMapping(value = "/addFromRequests", method = RequestMethod.POST)
	public String addFromRequests(int filmId, int quantity){
		if(username.getUsername() == null) return "redirect:/login";
		adminBl.addFromRequests(filmId, quantity);
		return "redirect:/login/admin/view";
	}
	
	
	@RequestMapping(value = "/addFromProvided", method = RequestMethod.POST)
	public String addFromProvided(int filmId, int quantity, int maxCopies){
		if(username.getUsername() == null) return "redirect:/login";
		if(quantity <= maxCopies) adminBl.addFromRequests(filmId, quantity);
		return "redirect:/login/admin/view";
	}
}
