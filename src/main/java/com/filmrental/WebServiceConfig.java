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
 * Entry point for WS configuration
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
     * 	Bean definition for the EndPoint initialization of the HelloService
     * @return
     * 		Returns the endpoint class published on the application
     */
    @Bean
    public Endpoint helloServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("/HelloService");
        return endpoint;
    }
    
    /**
     *  Bean definition for the EndPoint initialization of the CityService
     * @return
     * 		Returns the endpoint class published on the application
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
