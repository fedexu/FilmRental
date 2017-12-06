package com.filmrental.ws.service;

import javax.jws.WebService;

/**
 * Classe implementante del servizio "HelloService"
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
	 * Metodo contenente l'implementazione effettiva del WS. 
	 * E' l'entripoint applicativo dal quale possiamo agganciare tutti i @Service 
	 * necessari per la logica applicativa.
	 * 
	 */
    public String sayHello(String myname) {
    	
        return "Hello, Welcome to CXF Spring boot " + myname + "!!!";
    }

}