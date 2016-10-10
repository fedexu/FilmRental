package com.filmrental.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Admin")
	private boolean admin;
	
	@OneToMany(mappedBy="associatedUser")
	private Set<Rents> rentingUsers;
	
	
	public Set<Rents> getRentingUsers() {
		return rentingUsers;
	}
	public void setRentingUsers(Set<Rents> rentingUsers) {
		this.rentingUsers = rentingUsers;
	}
	public String getUsername() {
		return username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
