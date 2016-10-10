package com.filmrental.dao;

import java.util.List;

import com.filmrental.model.Users;

public interface UsersDao {
	/* Provides a list of all users */
	public List<Users> getAllUsers();
	
	/* Provides the user with the specified id */
	public Users getUserById(int id);
	
	/* Provides the user with the specified name */
	public Users getUserByUsername(String user);
}