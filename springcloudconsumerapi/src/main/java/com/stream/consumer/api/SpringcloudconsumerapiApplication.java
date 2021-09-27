package com.stream.consumer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import com.stream.consumer.api.modal.User;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringcloudconsumerapiApplication {
    private Logger logger=LoggerFactory.getLogger(SpringcloudconsumerapiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudconsumerapiApplication.class, args);
	}
	
	@StreamListener("input")
	public void consumeMessage(@Payload User user)
	{
		logger.info("consume message by rabbit:"+user);
	}
	
	@StreamListener("userexchange")
	public void consumeMessageUserexchange(@Payload User user)
	{
		logger.info("consume message by rabbit:"+user);
	}

}
