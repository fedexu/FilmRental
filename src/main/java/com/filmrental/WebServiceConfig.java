package com.filmrental;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;

import com.filmrental.repositories.CityRepository;
import com.filmrental.ws.service.CityServiceImpl;
import com.filmrental.ws.service.HelloServiceImpl;

/**
 * Entry point di configurazione per i servizi WS
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@EnableWs
@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    
    @Autowired
    private CityRepository cityRepository;
    
    /**
     * 	Definizione del bean per l'inizializzazione dell'endPoint del servizio HelloService
     * @return
     * 		Ritorna la classe di endpoint pubblicata sull'applicativo
     */
    @Bean
    public Endpoint helloServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/HelloService");
        return endpoint;
    }
    
    /**
     * 	Definizione del bean per l'inizializzazione dell'endPoint del servizio CityService
     * @return
     * 		Ritorna la classe di endpoint pubblicata sull'applicativo
     */
    @Bean
    public Endpoint cityServiceEndpoint() {
    	/*
    	 * Particolarita: la classe implementativa una volta data in pasto all'endPoint "esce" dal contesto 
    	 * di spring e non riesce ad effattuare l'injection degli autowired. 
    	 * Consiglio è di agganciare la classe Impl del servizio ad un @Service da cui possiamo agganciarci 
    	 * a tutto l'applicativo.
    	 * 
    	 */
    	CityServiceImpl cityService = new CityServiceImpl();
    	cityService.cityRepository = this.cityRepository;
    	
        EndpointImpl endpoint = new EndpointImpl(bus, cityService);
        endpoint.publish("/CityService");
        return endpoint;
    }
}
