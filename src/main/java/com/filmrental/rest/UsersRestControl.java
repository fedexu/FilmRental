package com.filmrental.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.control.UserSession;
import com.filmrental.model.WrapperUsersBl;

/* Rest controller is the annotation that is used in Spring 4 instead of the annotations @ResponseBody and @RequestMapping
 * paired with the @Controller, for some reasons however in our case is still necessary to use @RequestBody annotations
 * to effectively pass parameters */
@RestController
@RequestMapping("/rest/login/user")
public class UsersRestControl {
		
	@Autowired private UserSession username;
		
	@Autowired private WrapperUsersBl wrapperUsersBl;
	
	/* Requests the information necessary to display the user homepage namely the JSONS strings with:
	 * - film rented by the user at the moment
	 * - films available to rent by the user at the moment*/
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String displayUserView(){
		//TODO if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		return wrapperUsersBl.showUser(username.getUsername());
	}
	
	/* Maps the request to rent a new film*/
	@RequestMapping(value = "/rentFilm", method = RequestMethod.POST)
	public void rentFilm(@RequestBody Map<String, String> m){
		//TODO  if(username.getUsername() == null) return "redirect:/login";
		wrapperUsersBl.rentFilm(Integer.valueOf(m.get("filmId")));
	}
	
	/* Maps the request to return an owned film to the db*/
	@RequestMapping(value = "/returnFilm", method = RequestMethod.POST)
	public void returnFilm(@RequestBody Map<String, String> m){
		//TODO if(username.getUsername() == null) return "redirect:/login";
		wrapperUsersBl.returnFilm(Integer.valueOf(m.get("rentId")));
	}
}
