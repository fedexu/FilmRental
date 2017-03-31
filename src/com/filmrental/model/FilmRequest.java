package com.filmrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILMREQUEST")
public class FilmRequest {
	
	@Id
	@GeneratedValue  (strategy = GenerationType.AUTO)
	@Column (name = "REQUEST_ID")
	private int requestId;
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "REGIST")
	private String regist;
	@Column(name = "EXIT_YEAR")
	private int exitYear;

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
	
}
