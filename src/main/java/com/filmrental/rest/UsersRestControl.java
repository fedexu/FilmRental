package com.filmrental.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.UsersBl;
import com.filmrental.control.UserSession;
import com.filmrental.model.WrapperUsersBl;

@RestController
@RequestMapping("/rest/login/user")
public class UsersRestControl {
		
	@Autowired private UserSession username;
		
	@Autowired private WrapperUsersBl wrapperUsersBl;
	
	/* Maps the requests to view the users homepage*/
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String displayUserView(){
		//if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		return wrapperUsersBl.showUser(username.getUsername());
	}
	
	/* Maps the request to rent a new film*/
	@RequestMapping(value = "/rentFilm", method = RequestMethod.POST)
	public void rentFilm(@RequestParam("filmId") int filmId){
		//if(username.getUsername() == null) return "redirect:/login";
		wrapperUsersBl.rentFilm(filmId);
	}
	
	/* Maps the request to return an owned film to the db*/
	@RequestMapping(value = "/returnFilm", method = RequestMethod.POST)
	public void returnFilm(@RequestParam("returnId") int rentId){
		//if(username.getUsername() == null) return "redirect:/login";
		wrapperUsersBl.returnFilm(Integer.valueOf(rentId));
	}
}
