package com.filmrental.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.filmrental.bl.AdminBl;

@Service
public class WrapperAdminBl {
	
	@Autowired private AdminBl admBl;
	
	public String showAdmin(String u){
		
		ModelAndView res = admBl.showAdmin(u);
		Map map = res.getModel();
		List<Rents> currentRents 	= (List<Rents>) map.get("currentRents");
		List<Films> suggestedTitles = (List<Films>) map.get("suggestedTitles");
		List<Films> provided = (List<Films>) map.get("provided");
		String jsonString = "[" + currentRents.toString() + "," + suggestedTitles.toString() + "," + provided.toString() + "]";
		return jsonString;
	}
	
	/* Perform the adding of a new film to the db of all available films */
	public void addToCollection(String filmTitle, int quantity) {
		admBl.addToCollection(filmTitle, quantity);
	}
	
	/* Adds a film to the db from the list of requests by the users */
	public void addFromRequests(int id, int quantity){
		admBl.addFromRequests(id, quantity);
	}
}
