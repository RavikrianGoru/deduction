package com.example.casa.deduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableAsync
public class DeductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeductionApplication.class, args);
	}
	
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

}
