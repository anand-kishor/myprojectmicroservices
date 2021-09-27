package com.stream.producer.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stream.producer.api.channel.ProductChannel;
import com.stream.producer.api.modal.Product;

@RestController
@EnableBinding({Source.class,ProductChannel.class})
public class ProductController {
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private Source source;
	@Autowired
	@Qualifier("productOrders")
	private MessageChannel productOrder;
	@PostMapping("/product")
	public String addProduct(@RequestBody Product product)
	{
		productOrder.send(MessageBuilder.withPayload(product).build());
		logger.info("product send to client: "+product.toString());
		return "product send successfully";
	}
	
	@PostMapping("/product/orders")
	public String orderProduct(@RequestBody Product product)
	{
		productOrder.send(MessageBuilder.withPayload(product).build());
		logger.info("product send to client: "+product.toString());
		return "product send successfully";
	}
	

}
