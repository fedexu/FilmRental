package com.filmrental.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.control.UserSession;
import com.filmrental.model.WrapperAdminBl;

@RestController
@RequestMapping("/rest/login/admin")
public class AdminRestControl {
	@Autowired private UserSession username;
	
	@Autowired private WrapperAdminBl adminBl;
	
	/* Maps the requests to view the administrator homepage*/
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String displayAdminView(){
		//if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		return adminBl.showAdmin(username.getUsername());
	}
	
	/* Maps the request to add a new film to the db*/
	@RequestMapping(value = "/addToCollection", method = RequestMethod.POST)
	public void addToCollection(String filmTitle, int quantity){
		//if(username.getUsername() == null) return "redirect:/login";
		adminBl.addToCollection(filmTitle, quantity);
	}
	
	/* Maps the request to add a new film to the db from the list of films
	 * proposed by the users or provided by the */
	@RequestMapping(value = "/addFromRequests", method = RequestMethod.POST)
	public void addFromRequests(int filmId, int quantity){
		//if(username.getUsername() == null) return "redirect:/login";
		adminBl.addFromRequests(filmId, quantity);
	}
	
	@RequestMapping(value = "/addFromProvided", method = RequestMethod.POST)
	public void addFromProvided(int filmId, int quantity, int maxCopies){
		//if(username.getUsername() == null) return "redirect:/login";
		if(quantity <= maxCopies) adminBl.addFromRequests(filmId, quantity);
	}

}
