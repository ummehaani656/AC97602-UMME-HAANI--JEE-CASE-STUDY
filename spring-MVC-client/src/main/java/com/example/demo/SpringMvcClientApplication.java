package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcClientApplication.class, args);
	}
	@Bean
	public RestTemplate template(RestTemplateBuilder builder) {
		return builder.basicAuthentication("admin","admin").build();
	}
	   
	   public RestTemplateBuilder builder() {
		   return new RestTemplateBuilder();
	   
	   }
	  

}
