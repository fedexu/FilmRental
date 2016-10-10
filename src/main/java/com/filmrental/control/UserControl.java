package com.filmrental.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.UsersBl;

@Controller
@RequestMapping("/login/user")

public class UserControl {
	
@Autowired private UserSession username;
	
	@Autowired private UsersBl usersBl;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView displayUserView(){
		if(username.getUsername() == null) return new ModelAndView("redirect:/login");
		ModelAndView m = usersBl.showUser(username.getUsername());
		return m;
	}
	
	@RequestMapping(value = "/rentFilm", method = RequestMethod.POST)
	public String rentFilm(@RequestParam("filmId") int filmId){
		if(username.getUsername() == null) return "redirect:/login";
		usersBl.rentFilm(filmId);
		return "redirect:/login/user/view";
	}
	
	@RequestMapping(value = "/returnFilm", method = RequestMethod.POST)
	public String returnFilm(@RequestParam("returnId") int rentId){
		if(username.getUsername() == null) return "redirect:/login";
		System.out.println("CONTROLLER "+rentId);
		usersBl.returnFilm(Integer.valueOf(rentId));
		System.out.println("CONTROLLER "+rentId);
		return "redirect:/login/user/view";
	}
	@RequestMapping(value = "/addFilmRequest", method = RequestMethod.POST)
	public String addFilmRequest(@RequestParam("filmTitle") String filmTitle){
		if(username.getUsername() == null) return "redirect:/login";
		usersBl.addFilmRequest(filmTitle);
		return "redirect:/login/user/view";
	}
}
