package com.filmrental.control;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)

public class UserSession {
	private String username;
	private int id;
	private ModelAndView view;
	public void setView(ModelAndView view) {
		this.view = view;
	}

	public void setCk(boolean ck) {
		this.ck = ck;
	}

	public ModelAndView getView() {
		return view;
	}

	public boolean isCk() {
		return ck;
	}

	private boolean ck;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
