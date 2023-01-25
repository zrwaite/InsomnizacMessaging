package com.insomnizac.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.insomnizac.messaging.configs.Config;

@SpringBootApplication
public class MessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
		if (!Config.EnvLoaded()) {
			System.out.println("Error: .env file not loaded");
		}
	}

}
