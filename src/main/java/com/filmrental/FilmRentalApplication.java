package com.filmrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

/**
 * Entry point for spring boot configuration
 * 
 * @author Federico Peruzzi
 * @version 1.0
 *
 */
@ComponentScan({"com.filmrental"})
@EnableAutoConfiguration
@SpringBootApplication
public class FilmRentalApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FilmRentalApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(FilmRentalApplication.class, args);
	}
	
	
	
}
