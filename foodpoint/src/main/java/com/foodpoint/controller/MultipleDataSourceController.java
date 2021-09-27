package com.foodpoint.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.foodpoint.modal.CartItem;
import com.foodpoint.modal.User;
import com.foodpoint.repository.CartRepository;
import com.foodpoint.repository.UserRepository;
@RestController
public class MultipleDataSourceController {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void addData()
	{
		cartRepository.saveAll(Stream.of(new CartItem(1001,2),new CartItem(1002,6)).collect(Collectors.toList()));
		userRepository.saveAll(Stream.of(new User("anand","1234","anandkishor@gmail.com","delhi"),
				new User("kishor","kishor","kishor@gmail.com","india")).collect(Collectors.toList()));
	}
}
