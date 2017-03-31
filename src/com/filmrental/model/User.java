package com.filmrental.model;

public class User {
	private int User_Id;
	private String Username;
	private String U_Pass;
	private String First_Name;
	private String Last_Name;

	public User() {
		User_Id = 0;
		Username = null;
		U_Pass = null;
		First_Name = null;
		Last_Name = null;
	}

	// set get User_Id
	public void setUser_Id(int User_id) {
		this.User_Id = User_id;
	}

	public int getUser_Id() {
		return this.User_Id;
	}

	// set get Username
	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getUsername() {
		return this.Username;
	}

	// Set get U_Pass
	public void setU_Pass(String U_Pass) {
		this.U_Pass = U_Pass;
	}

	public String getU_Pass() {
		return this.U_Pass;
	}

	// set get First_Name
	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}

	public String getFirst_Name() {
		return this.First_Name;
	}

	// set get Last_Name
	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}

	public String getLast_Name() {
		return this.Last_Name;
	}
}
