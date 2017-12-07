package com.filmrental.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrental.entities.City;

/**
 * Reposiotry for handle the data object {@link City}
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	/**
	 * Implementation of the JPA repository
	 * Function for retrieve a {@link City} with the Id
	 * 
	 * @param id {@link int} unique
	 * 
	 * @return {@link City} find
	 */
	public City findByCityId(int cityId);
	
	/**
	 * Implementation of the JPA repository
	 * Function for retrieve a {@link City} with the countryId
	 * 
	 * @param id {@link int} unique
	 * 
	 * @return {@link City} find
	 */
	public List<City> findByCountryId(int countryId);
	
}
