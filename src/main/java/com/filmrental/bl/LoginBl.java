package com.filmrental.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.control.UserSession;
import com.filmrental.dao.UsersDao;
import com.filmrental.model.Users;

@Service
public class LoginBl {
	@Autowired private UserSession userSession;
	
	@Autowired private UsersDao userDao;
	
	public String checkUserName(String username){
		userSession.setUsername(username);
		Users usr = userDao.getUserByUsername(username);
		if(usr == null) return "redirect:/login";
		else{
			 userSession.setId(usr.getId());
			 if( usr.isAdmin() ) return "redirect:/login/admin/view";
			 else return "redirect:/login/user/view";
		}
	}

}
