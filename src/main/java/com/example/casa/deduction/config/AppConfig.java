package com.example.casa.deduction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class AppConfig {

	@Bean
	public OpenAPI openAPI()
	{
		return new OpenAPI()
			      .info(
			    		  	new Info()
			    		  		.title("CASA-Deduction-auto")
			    		  		.description("CASA-Deduction-auto description")
			    		  		.version("v0.1")
			    		  		.license(
			    		  				new License()
			    		  				.name("Apache 2.0")
			    		  	)
			    		 );
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
}
