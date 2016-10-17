package com.filmrental.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.filmrental.model.Films;
import com.filmrental.services.bl.ServicesBl;

public class ExternalProviderService {
	
	@Autowired ServicesBl servBl;

	private MyBean myBean = null;

	// Spring 'injects' this implementation
	public void setMyBean(MyBean myBean) {
		this.myBean = myBean;
	}

	// The actual web service:
	
	/* Request for all the requests by the users for the film actually in the db*/
	public Films[] getValue(){
		Films[] f = servBl.getAllProvidable();
		System.out.println("aaa"+f.length);
		for(int i = 0; i<f.length; i++)
		{
			System.out.println(f[i].toString());
		}
		return servBl.getAllProvidable();
    }
	
	/* Insert the request to provide a film among the requested ones*/
	public boolean provideFilm(int id, int count){
		return servBl.provideFilm(id, count);
	}
}