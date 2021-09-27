package com.stream.producer.api.conmponentconfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.stream.producer.api.config.RabbitConfig;
import com.stream.producer.api.modal.OrderStatus;

@Component
public class UserConfig {
	
	@RabbitListener(queues=RabbitConfig.QUEUE)
	public void receiveMessage(OrderStatus orderStatus)
	{
		System.out.println("received messaged by consumer :"+orderStatus);
	}

}
