package com.filmrental.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * Declaration of the interface service "HelloService".
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@WebService(targetNamespace = "http://www.FilmRental.com/ws", name = "HelloService")
public interface HelloService {
	
	/**
	 * Definition of the request and response object trougth JWS annotation.
	 * 
	 * @param myname
	 * @return
	 */
    @WebResult(name = "return", targetNamespace = "http://www.FilmRental.com/ws")
    @RequestWrapper(localName = "sayHello",
                    targetNamespace = "http://www.FilmRental.com/ws",
                    className = "com.filmrental.ws.service.SayHello")
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(localName = "sayHelloResponse",
                     targetNamespace = "http://www.FilmRental.com/ws",
                     className = "com.filmrental.ws.service.SayHelloResponse")
    String sayHello(@WebParam(name = "myname", targetNamespace = "http://www.FilmRental.com/ws") String myname);
}