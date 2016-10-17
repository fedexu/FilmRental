package com.filmrental.services.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.dao.FilmsDao;
import com.filmrental.model.Films;

@Service
public class ServicesBl {
	
	@Autowired private FilmsDao filmsDao;
	
	public ServicesBl(){ }
	
	/*Find all the providable films, i.e. films requested by the users and puts them in a vector 
	 * to satisfy compatibility with axis2 passage of complex object that does not supports lists*/
	public Films[] getAllProvidable(){
		List<Films> daoResult = filmsDao.getAllActiveRequests();
		System.out.println(daoResult.size());
		Films[] r = new Films[daoResult.size()];
		for(int i=0; i<daoResult.size(); i++){	
			if(daoResult.get(i).getCopies() == 0){
				Films film = new Films();
		        film.setCopies(daoResult.get(i).getCopies());
		        film.setTitle(daoResult.get(i).getTitle());
		        film.setId(daoResult.get(i).getId());
		        r[i] = film; 
		        System.out.println(r[i].getTitle());
			}
		}
		return r;
	}
	
	/* If a film is providable it issue the request to provide it to the dao*/
	public boolean provideFilm(int id, int copies){
		if(filmsDao.checkProvidable(id)){
			return filmsDao.setProvided(id, copies);
		}
		
		else return false;
	}
	

}
