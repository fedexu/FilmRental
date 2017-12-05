package com.filmrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entities.City;
import com.filmrental.form.entities.ExampleControllerMethodInput;
import com.filmrental.repositories.CityRepository;

/**
 * Service per gestire la business logic, la logica si scrive qui. 
 * Un service puo chiamare repositories o altri service piu bassi.
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
	 * Esempio di impelemtazione di logica applicativa
	 * 
	 * @param id {@link ExampleControllerMethodInput} 
	 * 
	 * @return {@link String} risultato
	 */
	public String exampleServiceMethod(ExampleControllerMethodInput exampleControllerMethodInput){
		
		List<City> l = cityRepository.findAll();
		
		return "ho trovato "+l.size()+" citta";
	}
	
}
