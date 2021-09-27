package com.cloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.modal.User;
import com.cloud.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	private Logger logger=LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("user/{id}")
	public User getUser(@PathVariable("id") String id)
	{
		logger.info("calling user getUser() method get all user");
		return userService.getUser(id);
	}
	@GetMapping("users")
	public List<User> getListUsers()
	{
		logger.info("all users");
		return userService.getUsers();
	}
	@PostMapping("user")
	public String addUser(@RequestBody User user)
	{
		logger.info("user adding  sucess");
		//userService.addUser(user);
		return userService.addUser(user);
	}
	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable String id)
	{
		userService.deleteUser(id);
		logger.info("delete user");
		return "user is deleted";
	}
	@RequestMapping(value="user/{id}/{newAddress}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable ("id") String id,@RequestParam (value="newAddress",required=false) String newAddress)
	{
		//userService.updateAddress(Long.parseLong(id),newAddress);
		return userService.updateAddress(id,newAddress);
	}
}

