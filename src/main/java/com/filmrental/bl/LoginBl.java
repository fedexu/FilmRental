package com.filmrental.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.control.UserSession;
import com.filmrental.dao.UsersDao;
import com.filmrental.model.Users;

@Service
public class LoginBl {
	
	// User session
	@Autowired private UserSession userSession;
	
	@Autowired private UsersDao userDao;
	
	/* Checks if the user does exists in the database of the registered users if it does
	 * prepares a redirect to their homepages (user or admin) if not it redirects again to the login page.
	 * 
	 * This is an issue both of view that of logic I decided to put it here for simplicity even if it could have
	 * been implemented, maybe more correctly, by moving the redirects on the controllers and pass only some variables
	 * from the Business Logic */
	public String checkUserName(String username){
		userSession.setUsername(username);
		Users usr = userDao.getUserByUsername(username);
		if(usr == null) return "redirect:/login";
		else{
			userSession.setId(usr.getId());
			//userSession.setSessionId();
			if( usr.isAdmin() ) {
				 userSession.setStatus("admin");
				 return "redirect:/login/admin/view";
			}
			else {
				userSession.setStatus("user");
				 return "redirect:/login/user/view";
			}
		}
	}

}
