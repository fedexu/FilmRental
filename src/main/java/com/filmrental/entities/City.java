package com.filmrental.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity per la tabella City
 * 
 * @author Federico Peruzzi
 * @version 1.0
 * 
 */
@Entity
@Table(name="City")
public class City {
	
	@Id
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city")
	private String cityName;
	
	@Column(name = "country_id")
	private int countryId;
	
	@Column(name = "last_update")
	private Date lastUpdate;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}

