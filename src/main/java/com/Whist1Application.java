package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.Test;


//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,WebMvcAutoConfiguration.class })
@SpringBootApplication
public class Whist1Application {

	@Autowired
	Test test;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(Whist1Application.class, args);
		
		
	
		
		
			
		 
		
	
	

}
}
