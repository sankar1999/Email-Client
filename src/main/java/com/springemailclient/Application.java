package com.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class Application {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {SpringApplication.run(Application.class, args);}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		//service.sendSimpleEmail("sankarsathya1999@gmail.com", "This is the Email Body", "Spring Boot Email");


		service.sendEmailWithAttachment("sankarsathya1999@gmail.com",
				"This is email body with Attachment...",
				"This email has Attachment",
				"/Users/sankar/Downloads/Elon2.jpeg");
	}

}
