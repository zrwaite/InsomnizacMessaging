package com.insomnizac.messaging.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.insomnizac.messaging.models.MessageModels;
import com.insomnizac.messaging.services.Auth;
import com.insomnizac.messaging.services.Email;
import com.insomnizac.messaging.utils.Time;

@RestController
public class EmailController {
	@PostMapping("/email")
	public String Email(@RequestBody MessageModels.MessageRequest body, @RequestHeader("Authorization") String bearerToken) {
		if (!Auth.validateToken(bearerToken)) return "Invalid API key";
		String inputErrors = body.InputErrors();
		if (inputErrors != null) return inputErrors;
		Email.SendEmail(body.to, body.message);
		return "Message sent: " + Time.stamp();
	}

	@PostMapping("/email_me")
	public String EmailMe(@RequestBody MessageModels.MessageMeRequest body, @RequestHeader("Authorization") String bearerToken) {
		if (!Auth.validateToken(bearerToken)) return "Invalid API key";
		String inputErrors = body.InputErrors();
		if (inputErrors != null) return inputErrors;
		Email.SendEmailToMe(body.message);
		return "Message sent: " + Time.stamp();
	}

}
