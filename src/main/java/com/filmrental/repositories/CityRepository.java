package com.filmrental.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrental.entities.City;

/**
 * Reposiotry per la gestione dell'oggetto {@link City}
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	/**
	 * Implementazione dei JPA repository
	 * Funzione per recuperare una {@link City} tramite l'id
	 * 
	 * @param id {@link int} univoco
	 * 
	 * @return {@link City} recuperato
	 */
	public City findByCityId(int cityId);
	
	/**
	 * Implementazione dei JPA repository
	 * Funzione per recuperare un gruppo di {@link City} tramite il country Id
	 * 
	 * @param id {@link int} univoco
	 * 
	 * @return {@link City} recuperato
	 */
	public List<City> findByCountryId(int countryId);
	
}
