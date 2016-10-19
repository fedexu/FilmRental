package com.filmrental.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.control.UserSession;
import com.filmrental.model.WrapperAdminBl;

/* Rest controller is the annotation that is used in Spring 4 instead of the annotations @ResponseBody and @RequestMapping
 * paired with the @Controller, for some reasons however in our case is still necessary to use @RequestBody annotations
 * to effectively pass parameters */
@RestController
@RequestMapping("/rest/login/admin")
public class AdminRestControl {
	@Autowired private UserSession username;
	
	@Autowired private WrapperAdminBl adminBl;
	
	/* Requests the information necessary to display the admin homepage namely the JSONS strings with:
	 * - film rented at the moment
	 * - requests from users
	 * - requests from providers*/
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String displayAdminView(){
		//TODO if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		return adminBl.showAdmin(username.getUsername());
	}
	
	/* Maps the request to add a new film to the db*/
	@RequestMapping(value = "/addToCollection", method = RequestMethod.POST)
	public void addToCollection(@RequestBody  Map<String, String> m ){
		//TODO if(username.getUsername() == null) return "redirect:/login";
		adminBl.addToCollection(m.get("filmTitle"), Integer.valueOf(m.get("quantity")));
	}
	
	/* Maps the request to add a new film to the db from the list of films
	 * proposed by the users*/
	@RequestMapping(value = "/addFromRequests", method = RequestMethod.POST)
	public void addFromRequests(@RequestBody Map<String, String> m){
		//TODO if(username.getUsername() == null) return "redirect:/login";
		adminBl.addFromRequests(Integer.valueOf(m.get("filmTitle")), Integer.valueOf(m.get("quantity")));
	}
	
	/* Maps the request to add a new film to the db from the list of films
	 * proposed by the provider */
	@RequestMapping(value = "/addFromProvided", method = RequestMethod.POST)
	public void addFromProvided(@RequestBody Map<String, String> m){
		if(Integer.valueOf(m.get("quantity")) <= Integer.valueOf(m.get("maxCopies")) ){
			adminBl.addFromRequests(Integer.valueOf(m.get("filmId")), Integer.valueOf(m.get("quantity")));
		//TODO if(username.getUsername() == null) return "redirect:/login";
		}
	}
}
