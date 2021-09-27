package com.cloudm.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cloudm.model.User;

public interface UserService {
	
	

	List<User> getAllUsers();

	User getUser(String id);

	void addUser(User user);

	User updateUser(User user);

	User deleteUser(String id);

	void updateAddress(String id, String newAddress);

}
