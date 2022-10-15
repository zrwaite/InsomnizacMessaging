package com.insomnizactwilio.insomnizactwilioapi.configs;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
	public static final Dotenv ENV = Dotenv.load();
	public static String getenv(String key) {
		return ENV.get(key);
	}
	public static boolean EnvLoaded() {
		return ENV.get("API_KEY") != null;
	}
}
