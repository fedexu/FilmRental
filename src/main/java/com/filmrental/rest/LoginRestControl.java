package com.filmrental.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.Users;
import com.filmrental.model.WrapperLoginBl;

/* Rest controller is the annotation that is used in Spring 4 instead of the annotations @ResponseBody and @RequestMapping
 * paired with the @Controller, for some reasons however in our case is still necessary to use @RequestBody annotations
 * to effectively pass parameters */
@RestController
@RequestMapping("/rest")
public class LoginRestControl {
	@Autowired private WrapperLoginBl wrapperLoginBl;
	
	/* Requesting user profile: returns "fail" if user not present, "admin" or "user" if the user is present*/
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes="application/json")
	public String logIn(@RequestBody Users user) {
		return wrapperLoginBl.checkUserName(user.getUsername());
	}	
}
