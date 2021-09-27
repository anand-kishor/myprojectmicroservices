package com.stream.producer.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

//import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.converter.MarshallingMessageConverter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stream.producer.api.modal.Product;
import com.stream.producer.api.modal.User;

@EnableBinding(Source.class)
@RestController
@SpringBootApplication
public class SpringcloudproducerapiApplication {
	
	@Autowired
	private MessageChannel output;
	
	@Autowired
	private AmqpTemplate template;
	
	
	
	@PostMapping("/publish")
	public User publishUser(@RequestBody User user)
	{
		output.send(MessageBuilder.withPayload(user).build());
		return user;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudproducerapiApplication.class, args);
	}
	@Bean
    public ApplicationRunner runner(AmqpTemplate template) {
        return args -> template.convertAndSend("myqueue", "foo");
    }
	
	@RabbitListener(queues = "myqueue")
    public void listen(String in) {
        System.out.println(in);
    }
	@StreamListener("payments")
	public void handleProductListener(Product product)
	{
		System.out.println("stream listener listene message :"+product);
	}
	@StreamListener("inputuser")
	public void handleUserListener(User user)
	{
		System.out.println("stream listener listene message :"+user);
	}
}
