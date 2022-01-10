package com.example.RkMail.services;

import com.example.RkMail.dtos.EmailDtos;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {

    final Configuration configuration;

    @Autowired
    private JavaMailSender mailSender;

    public EmailSenderService(Configuration configuration) {
        this.configuration = configuration;
    }


    public void sendMailWithAttachment(String toEmail,String subject,String body,String Attachment) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        String emailContent = getEmailContent(subject,body);
        mimeMessageHelper.setFrom("rahulmanakyalath@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(emailContent,true);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(Attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        mailSender.send(mimeMessage);
        System.out.println("mail send successfully");

    }
    String getEmailContent(String subject,String buddy) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user",subject);
        model.put("Buddy_coder",buddy);
        configuration.getTemplate("email.ftl").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
