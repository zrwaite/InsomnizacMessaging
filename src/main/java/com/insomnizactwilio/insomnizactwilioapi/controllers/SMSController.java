package com.insomnizactwilio.insomnizactwilioapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insomnizactwilio.insomnizactwilioapi.models.SMSModels;
import com.insomnizactwilio.insomnizactwilioapi.services.SMS;
import com.insomnizactwilio.insomnizactwilioapi.utils.Time;

@RestController
public class SMSController {
	
	@GetMapping("/message")
	public String message(@RequestBody SMSModels.MessageRequest body) {
		SMS.SendMessage(body.to, body.message);
		return "Message sent: " + Time.stamp();
	}

	@GetMapping("/messageMe")
	public String messageMe(@RequestBody SMSModels.MessageMeRequest body) {
		SMS.SendMessageToMe(body.message);
		return "Message sent: " + Time.stamp();
	}

}
