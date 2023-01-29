package com.insomnizac.messaging.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.insomnizac.messaging.models.SMSModels;
import com.insomnizac.messaging.services.Auth;
import com.insomnizac.messaging.services.SMS;
import com.insomnizac.messaging.utils.Time;

@RestController
public class SMSController {
	@PostMapping("/message")
	public String message(@RequestBody SMSModels.MessageRequest body, @RequestHeader("Authorization") String bearerToken) {
		if (!Auth.validateToken(bearerToken)) {
			return "Invalid API key";
		}
		String inputErrors = body.InputErrors();
		if (inputErrors != null) {
			return inputErrors;
		}
		SMS.SendMessage(body.to, body.message);
		return "Message sent: " + Time.stamp();
	}

	@PostMapping("/messageMe")
	public String messageMe(@RequestBody SMSModels.MessageMeRequest body, @RequestHeader("Authorization") String bearerToken) {
		if (!Auth.validateToken(bearerToken)) {
			return "Invalid API key";
		}
		String inputErrors = body.InputErrors();
		if (inputErrors != null) {
			return inputErrors;
		}
		SMS.SendMessageToMe(body.message);
		return "Message sent: " + Time.stamp();
	}

}
