package com.cloudm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudm.model.User;
import com.cloudm.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getAllUsers();
	}
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable String id)
	{
		return userService.getUser(id);
	}
	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User user)
	{
		userService.addUser(user);
		URI path=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(path).build();
	}
	@PutMapping("/user/{id}/{newAddress}")
	public String updateUser(@PathVariable ("id") String id,@RequestParam ("newAddress") String newAddress)
	{
		userService.updateAddress(id,newAddress);
		return "update user address";
	}
	@DeleteMapping("/user/{id}")
	public User deleteUser(String id)
	{
		return userService.deleteUser(id);
	}
	

}
