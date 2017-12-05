package com.filmrental.ws.service;

import javax.jws.WebService;


@WebService(serviceName = "HelloService", portName = "HelloPort",
                    targetNamespace = "http://www.FilmRental.com/ws",
                    endpointInterface = "com.filmrental.ws.service.HelloService")
public class HelloServiceImpl implements HelloService {

    public String sayHello(String myname) {
    	
        return "Hello, Welcome to CXF Spring boot " + myname + "!!!";
    }

}