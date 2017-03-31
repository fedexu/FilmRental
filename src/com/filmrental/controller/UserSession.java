package com.filmrental.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.filmrental.model.Film;
import com.filmrental.model.FilmRent;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {

	private String username;
	private int userId;
	private List<FilmRent> rentfilms;

	public UserSession() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<FilmRent> getRentfilms() {
		return rentfilms;
	}

	public void setRentfilms(List<FilmRent> rentfilms) {
		this.rentfilms = rentfilms;
	}

}
