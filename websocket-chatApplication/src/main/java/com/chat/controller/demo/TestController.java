package com.chat.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chat.model.ChatMessagePojo;

@Controller
public class TestController {
	
	@GetMapping("/demo/{id}")
	public  String getStudentById(@PathVariable("id") int id)
	{
		return "get api";
	}
	@PostMapping("/student")
	public String saveStudent(@RequestBody ChatMessagePojo hatMessagePojo)
	{
		return "";
	}

}
