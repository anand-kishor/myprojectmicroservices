package com.smssend;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URI;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
@SpringBootApplication
public class SendsmsonmobileApplication implements ApplicationRunner {
	 //private final String ACCOUNT_SID ="enter your SID Number from Twilio";
    private final static String SID_ACCOUNT="ACde13a77c53e56f58102808e1b1c7e7d2";

    //private final String AUTH_TOKEN = "enter your Auth token from Twilio Account";
    private final static String AUTH_ID="720d4336ddd192c9cf09a28dc119906d";

    private final static String FROM_NUMBER = "+19514331296";
    private final static String TO_NUMBER = "+919643225141";
    
    static {
    	   Twilio.init(SID_ACCOUNT, AUTH_ID);
    	}

	public static void main(String[] args) {
		SpringApplication.run(SendsmsonmobileApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				   new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
	}

}
