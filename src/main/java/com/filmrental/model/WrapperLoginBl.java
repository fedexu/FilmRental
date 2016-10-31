package com.filmrental.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.bl.LoginBl;

@Service
public class WrapperLoginBl {

	@Autowired private LoginBl loginBl;
	
	public WrapperLoginBl(){ }
	
	/*Wrapping the Login output to be used with JSONS*/
	public String checkUserName(String user){
		String res = loginBl.checkUserName(user);
		if(res == "redirect:/login/admin/view") return "{\"status\":\"admin\"}";
		else if(res == "redirect:/login/user/view") return "{\"status\":\"user\"}";
		else return "{\"status\":\"fail\"}";
	}
}
