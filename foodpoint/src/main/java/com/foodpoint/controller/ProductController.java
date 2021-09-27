package com.foodpoint.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;


@Controller
public class ProductController {
	@Value("${uploadDir}")
	private String uploadFolder;
	


}
