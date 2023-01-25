package com.insomnizac.messaging.services;

import com.insomnizac.messaging.configs.Config;

public class Auth {
	public static boolean validateToken(String bearerToken) {
		return bearerToken != null && bearerToken.equals("Bearer " + Config.getenv("API_KEY"));
	}
}
