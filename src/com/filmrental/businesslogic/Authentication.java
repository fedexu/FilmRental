package com.filmrental.businesslogic;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.filmrental.dao.DBUsers;
import com.filmrental.model.User;

public class Authentication {
	private DBUsers user;
	private boolean ris;

	public Authentication() {
	}

	public boolean matchUser(String username, String u_Pass) {
		user = new DBUsers();
		List<User> list =  user.selectUserByCredential(username, u_Pass);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsername().equals(username) && list.get(i).getPass().equals(u_Pass)) {
				ris = true;
				break;
			} else {
				ris = false;
			}
		}

		return ris;
	}

	public boolean isAdmin(String username, String u_Pass) {
		Authentication a = new Authentication();
		if (a.matchUser(username, u_Pass)) {
			if (username.equals("admin") && u_Pass.equals("admin")) {
				ris = true;
			} else {
				ris = false;
			}
		} else {
			ris = false;
		}
		return ris;
	}
}
