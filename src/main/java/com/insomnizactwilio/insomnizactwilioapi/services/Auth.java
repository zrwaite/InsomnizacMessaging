package com.insomnizactwilio.insomnizactwilioapi.services;

import com.insomnizactwilio.insomnizactwilioapi.configs.Config;

public class Auth {
	public static boolean validateToken(String bearerToken) {
		return bearerToken != null && bearerToken.equals("Bearer " + Config.getenv("API_KEY"));
	}
}
