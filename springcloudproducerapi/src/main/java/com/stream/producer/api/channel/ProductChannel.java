package com.stream.producer.api.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProductChannel {
	@Output
	MessageChannel productOrders();
	@Input
	SubscribableChannel payments();
	

}
