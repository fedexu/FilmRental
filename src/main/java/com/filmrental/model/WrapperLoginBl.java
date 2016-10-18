package com.filmrental.model;

import com.filmrental.bl.LoginBl;

public class WrapperLoginBl {

	private LoginBl loginBl;
	
	public WrapperLoginBl(){ }
	
	public String checkUserName(String user){
		String res = loginBl.checkUserName(user);
		if(res == "redirect:/login") return "fail";
		else if(res == "redirect:/login/admin/view") return "admin";
		else if(res == "redirect:/login/user/view") return "user";
		else return null;
	}

}
