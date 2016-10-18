package com.filmrental.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="films")
public class Films {
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Copies")
	private int copies;
	
	@Column(name="Requested")
	private int requested;
	
	@Column(name="Approved")
	private boolean approved;
	
	@OneToMany(mappedBy="film")
	private Set<Rents> rentedFilms;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getRequested() {
		return requested;
	}

	public void setRequested(int requested) {
		this.requested = requested;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Set<Rents> getRentedFilms() {
		return rentedFilms;
	}

	public void setRentedFilms(Set<Rents> rentedFilms) {
		this.rentedFilms = rentedFilms;
	}
	
	@Override
	public String toString(){
		return "{"
				+ "\" id:\": \" "+ this.id +" \" ,"
				+ "\" title:\": \" "+ this.title +" \" ,"
				+ "\" copies: \": \" "+ this.copies +" \" ,"
				+ "\" requested: \": \" "+ this.getRequested() +" \" ,"
				+ "\" approved: \": \" "+ this.isApproved() +" \" }";
	}
	
	public String toString(String complete)
	{   
		complete.replace("}", "\",");
		complete = complete + " \"rentingUsers\": [";
		for(int i=0; i<rentedFilms.size(); i++){
			complete = complete + rentedFilms.toString();
			complete = complete + ", ";
		}
		complete = complete + "]}";
		
		return complete;
	}

}
