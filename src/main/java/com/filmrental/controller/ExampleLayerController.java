package com.filmrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.RestResponseEntity;
import com.filmrental.form.entities.ExampleControllerMethodInput;
import com.filmrental.service.ExampleLayerService;

/**
 * Controller to handle the application entryPoints.
 * We don't write business logic here.
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
	 * Example of an entryPoint implementation for a REST call
	 * 
	 * @param id {@link ExampleControllerMethodInput} 
	 * 
	 * @return {@link String} result
	 */
	@RequestMapping(value="method", method=RequestMethod.POST, produces = "application/json")
	public RestResponseEntity<String> exampleControllerMethod(@RequestBody ExampleControllerMethodInput exampleControllerMethodInput) {

		return new RestResponseEntity<>(exampleLayerService.exampleServiceMethod(exampleControllerMethodInput));
	}
	
	
}
