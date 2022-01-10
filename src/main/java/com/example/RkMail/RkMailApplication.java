package com.example.RkMail;

import com.example.RkMail.services.EmailSenderService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class RkMailApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(RkMailApplication.class, args);

	}
		@EventListener(ApplicationReadyEvent.class)
				public void sendMail() throws MessagingException, IOException, TemplateException {
	//	senderService.sendMailWithAttachment("rahulydp1631d@gmail.com","Learning","rahul","C:/Users/rahul/Desktop/Resume Rahul Kumar Ms.pdf");

		}


}
