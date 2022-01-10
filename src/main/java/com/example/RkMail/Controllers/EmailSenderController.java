package com.example.RkMail.Controllers;

import com.example.RkMail.dtos.EmailDtos;
import com.example.RkMail.services.EmailSenderService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class EmailSenderController {

    @Autowired
    public EmailSenderService emailSenderService;

    @PostMapping("/sendmail")
    public ResponseEntity<String> sendEmailDetails(@RequestBody final EmailDtos emailDtos){
        try{
            emailSenderService.sendMailWithAttachment(emailDtos.getReceiverMailId(),emailDtos.getSubject(),emailDtos.getBody(),emailDtos.getAttachment());
            return ResponseEntity.created(new URI("http://localhost:8089/spring-mail-app/api/v1/sendmail/")).build();
        } catch (TemplateException |IOException |URISyntaxException |MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}