package com.stream.producer.api.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserChannel {
	
	@Output
	MessageChannel outputuser();
	
	@Input
	SubscribableChannel inputuser();

}
