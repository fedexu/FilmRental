package com.filmrental.model;

public class FilmRequest {

	private int userId;
	private String title;
	private String regist;
	private int exitYear;
	private int requestId;
	private User user;

	public FilmRequest() {
		userId = 0;
		title = null;
		regist = null;
		exitYear = 0;
		requestId = 0;
	}

	// set e get di userId
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return this.userId;
	}

	// set get title
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// set get regist
	public void setRegist(String regist) {
		this.regist = regist;
	}

	public String getRegist() {
		return this.regist;
	}

	// set e get di exitYear
	public void setExitYear(int exitYear) {
		this.exitYear = exitYear;
	}

	public int getExitYear() {
		return this.exitYear;
	}
	
	// set e get di requestId
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequestId() {
		return this.requestId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
