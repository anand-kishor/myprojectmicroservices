package com.cloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.modal.User;

//@FeignClient(name="feginUserService",url="http://localhost:9090/")
@FeignClient(name="${service.base}",url="${service.base.url}")
public interface UserService {
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable ("id") String id);
	
	@GetMapping(value="/users")
	public List<User> getUsers();
	
    @PostMapping("/user")
    public String addUser(User user);
    
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id);
   
	
	 @PutMapping("/user/{id}/{newAddress}")
	public String updateAddress(@PathVariable ("id")String id,@RequestParam ("newAddress")String newAddress);
}
