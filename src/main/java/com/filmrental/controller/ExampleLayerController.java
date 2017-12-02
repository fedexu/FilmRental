package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.form.entities.ExampleControllerMethodInput;
import com.filmrental.service.ExampleLayerService;

/**
 * Controller per gestire gli entry point applicativi.
 * Non si scrive logica qui.
 * 
 * @author Federico Peruzzi
 * @version
 * 
 */
@RequestMapping(path="example")
@RestController
public class ExampleLayerController {
	
	@Autowired
	private ExampleLayerService exampleLayerService;
	
	/**
	 * Esempio di impelemtazione entry-point applicativo REST
	 * 
	 * @param id {@link ExampleControllerMethodInput} 
	 * 
	 * @return {@link String} risultato
	 */
	@RequestMapping(value="method", method=RequestMethod.POST)
	public String exampleControllerMethod(@RequestBody ExampleControllerMethodInput exampleControllerMethodInput) {
		
		return exampleLayerService.exampleServiceMethod(exampleControllerMethodInput);
	}
	
}
