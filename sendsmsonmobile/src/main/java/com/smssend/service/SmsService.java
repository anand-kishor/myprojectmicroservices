package com.smssend.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.smssend.model.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {

	    
	    //private final String ACCOUNT_SID ="enter your SID Number from Twilio";
	    private final String ACCOUNT_SID ="ACde13a77c53e56f58102808e1b1c7e7d2";

	    //private final String AUTH_TOKEN = "enter your Auth token from Twilio Account";
	    private final String AUTH_TOKEN="720d4336ddd192c9cf09a28dc119906d";

	    private final String FROM_NUMBER = "+19514331296";
	    //private final String FROM_NUMBER = "9643225141";
	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}