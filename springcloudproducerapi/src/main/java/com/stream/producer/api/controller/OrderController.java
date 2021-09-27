package com.stream.producer.api.controller;

import java.util.UUID;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.producer.api.channel.OrderChannel;
import com.stream.producer.api.channel.ProductChannel;
import com.stream.producer.api.config.RabbitConfig;
import com.stream.producer.api.modal.Order;
import com.stream.producer.api.modal.OrderStatus;


@EnableBinding({Source.class,OrderChannel.class})
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private MessageChannel outputorder;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@PostMapping("/{restaurantName}")
	public String postOrder(@RequestBody Order order,@PathVariable String restaurantName )
	{
		order.setOrderId(UUID.randomUUID().toString());
		OrderStatus orderStatus=new OrderStatus(order,"PROCESS","ORDER PLACED IS SUCCESSFULLY :"+restaurantName);
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, orderStatus);
		return "SUCCESS";
	}
	@PostMapping("/postorder")
	public String postOrder(@RequestBody Order order)
		{
		outputorder.send(MessageBuilder.withPayload(order).build());
		return "post order in rabbitmq middleware";
	    }
	

}
