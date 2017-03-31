package com.filmrental.model_view;

public class RequestView {
	private int userId;
	private String title;
	private String regist;
	private int exitYear;
	private int quantity;
	
	public RequestView(){
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegist() {
		return regist;
	}
	public void setRegist(String regist) {
		this.regist = regist;
	}
	public int getExitYear() {
		return exitYear;
	}
	public void setExitYear(int exitYear) {
		this.exitYear = exitYear;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
