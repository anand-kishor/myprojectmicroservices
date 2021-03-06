package com.stream.producer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stream.producer.api.channel.UserChannel;
import com.stream.producer.api.modal.User;

@RestController
@EnableBinding({Source.class,UserChannel.class})
public class UserController {
	
	@Autowired
	private Source source;
	
	@Autowired
	@Qualifier("outputuser")
	private MessageChannel outputuser;
	
	@PostMapping("/adduser/xobject")
	public String addUserXobject(@RequestBody User user)
	{
		outputuser.send(MessageBuilder.withPayload(user)
				.setHeader("contentType", "appliction/x-java-object;type=com.stream.producer.api.modal.User")
				.setHeader("add-user", "user-anand").build());
		return "add user success";
	}
	
	@PostMapping("/adduser/str")
	public String addUser(@RequestBody User user)
	{
		outputuser.send(MessageBuilder.withPayload(user)
				.setHeader("contentType", "text/plain")
				.setHeader("add-user", "user-anand").build());
		return "add user success";
	}
	@PostMapping("/adduser/json")
	public String addUserDetails(@RequestBody User user)
	{
		
		outputuser.send(MessageBuilder.withPayload(user).build());
		
		return "success";
	}

}
