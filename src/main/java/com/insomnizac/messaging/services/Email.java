package com.insomnizac.messaging.services;

import com.insomnizac.messaging.configs.Config;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
	
	
	public static final String FROM_EMAIL = Config.getenv("EMAIL");
	public static final String PASSWORD = Config.getenv("EMAIL_PASSWORD");

	public static void SendEmail(String to, String body) {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(
			prop,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
				}
			}
		);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM_EMAIL));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Insomnizac Messaging");
			message.setText(body);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void SendEmailToMe(String body) {
		SendEmail(FROM_EMAIL, body);
		System.out.println("Sent email to me");
	}

}
