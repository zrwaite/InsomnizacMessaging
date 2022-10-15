package com.insomnizactwilio.insomnizactwilioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.insomnizactwilio.insomnizactwilioapi.configs.Config;

@SpringBootApplication
public class InsomnizacTwilioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsomnizacTwilioApplication.class, args);
		if (!Config.EnvLoaded()) {
			System.out.println("Error: .env file not loaded");
		}
	}

}
