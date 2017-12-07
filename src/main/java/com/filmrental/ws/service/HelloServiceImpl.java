package com.filmrental.ws.service;

import javax.jws.WebService;

/**
 * Implementation of the service "HelloService".
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@WebService(serviceName = "HelloService", portName = "HelloPort",
                    targetNamespace = "http://www.FilmRental.com/ws",
                    endpointInterface = "com.filmrental.ws.service.HelloService")
public class HelloServiceImpl implements HelloService {

	/**
	 * Method with the implementation of the WS service. 
	 * The application entry point where we can link all @service object nedded 
	 * for the business logic. 
	 * 
	 */
    public String sayHello(String myname) {
    	
        return "Hello, Welcome to CXF Spring boot " + myname + "!!!";
    }

}