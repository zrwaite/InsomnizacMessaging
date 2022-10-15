package com.insomnizactwilio.insomnizactwilioapi.services;

import com.insomnizactwilio.insomnizactwilioapi.configs.Config;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;

public class SMS {
	public static final String ACCOUNT_SID = Config.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = Config.getenv("TWILIO_AUTH_TOKEN");
	public static final String TWILIO_NUMBER = Config.getenv("TWILIO_NUMBER");
	public static final String MY_NUMBER = Config.getenv("MY_NUMBER");

    public static void SendMessage(String to, String body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
			new com.twilio.type.PhoneNumber(to),
			new com.twilio.type.PhoneNumber(TWILIO_NUMBER),
			body
		).create();
        System.out.println(message.getSid());
    }

	public static void SendMessageToMe(String body) {
		SendMessage(MY_NUMBER, body);
		System.out.println("Sent message to me");
	}
	
}
