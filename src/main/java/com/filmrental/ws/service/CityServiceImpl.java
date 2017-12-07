package com.filmrental.ws.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.filmrental.entities.City;
import com.filmrental.repositories.CityRepository;

/**
 * Implementation of the service "CityService".
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@WebService(serviceName = "CityService", portName = "CityPort",
                    targetNamespace = "http://www.FilmRental.com/ws",
                    endpointInterface = "com.filmrental.ws.service.CityService")
@Component
public class CityServiceImpl implements CityService {

	public CityRepository cityRepository;
	
	public List<City> getCity() {
		
		return cityRepository.findAll();
	}

}