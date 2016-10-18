package com.filmrental.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.model.Users;
import com.filmrental.model.WrapperLoginBl;

@RestController
@RequestMapping("/rest")
public class LoginRestControl {

	private WrapperLoginBl wrapperLoginBl;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logIn(Users user) {
		return wrapperLoginBl.checkUserName(user.getUsername());
	}	
}
