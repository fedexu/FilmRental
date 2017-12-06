package com.filmrental.ws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.filmrental.entities.City;

/**
 * Interfaccia dichairativa del servizio "CityService"
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@WebService(targetNamespace = "http://www.FilmRental.com/ws", name = "CityService")
public interface CityService {
	
	/**
	 * Definizione dell'oggetto request e response tramite le annotazioni Jws
	 * 
	 * @param myname
	 * @return
	 */
    @WebResult(name = "return", targetNamespace = "http://www.FilmRental.com/ws")
    @RequestWrapper(localName = "getCity",
                    targetNamespace = "http://www.FilmRental.com/ws",
                    className = "com.filmrental.ws.service.GetCity")
    @WebMethod(action = "urn:GetCity")
    @ResponseWrapper(localName = "getCityResponse",
                     targetNamespace = "http://www.FilmRental.com/ws",
                     className = "com.filmrental.ws.service.GetCity")
    List<City> getCity();
}