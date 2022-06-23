package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailsender {
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail,String Subject,String Body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("piazomato@gmail.com");
        message.setTo(toEmail);
        message.setText(Body);
        message.setSubject(Subject);
        mailSender.send(message);
    }
}


