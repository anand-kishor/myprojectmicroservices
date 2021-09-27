package com.ecommerce;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.controller.HomeController;

@SpringBootApplication
public class PatnahubApplication  {
	
	public static void main(String[] args) {
		new File(HomeController.uploadDirectory).mkdir();
		SpringApplication.run(PatnahubApplication.class, args);
	}

}
