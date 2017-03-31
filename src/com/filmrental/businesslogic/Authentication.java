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

	public boolean matchUser(String Username, String U_Pass) {
		user = new DBUsers();
		try {
			List<User> list = user.selectAllUsers();
			for (int i =0;i<list.size();i++) {
				if (list.get(i).getUsername().equals(Username) && list.get(i).getU_Pass().equals(U_Pass)) {
					ris = true;
					break;
				} else {
					ris = false;
				}
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ris;
	}

	public boolean isAdmin(String Username, String U_Pass) {
		Authentication a = new Authentication();
		if (a.matchUser(Username, U_Pass)) {
			if (Username.equals("admin") && U_Pass.equals("admin")) {
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
