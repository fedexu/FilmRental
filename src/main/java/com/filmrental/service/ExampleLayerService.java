package com.filmrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entities.City;
import com.filmrental.form.entities.ExampleControllerMethodInput;
import com.filmrental.repositories.CityRepository;

/**
 * Service class for handling and implementing the business logic.
 * A service class can call a repository or other services on a lower. 
 * 
 * @author Federico Peruzzi
 * @version
 * 
 */

@Service
public class ExampleLayerService {

	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * Example of an implementation of business logic.
	 * 
	 * @param id {@link ExampleControllerMethodInput} 
	 * 
	 * @return {@link String} risultato
	 */
	public String exampleServiceMethod(ExampleControllerMethodInput exampleControllerMethodInput){
		
		List<City> cityList = cityRepository.findAll();
		
		return "ho trovato "+cityList.size()+" citta";
	}
	
}
