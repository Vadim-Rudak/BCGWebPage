package com.bears.webPage.service;

import com.bears.webPage.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmailService implements EmailService{

    @Autowired
    public JavaMailSender emailSender;


    @Override
    public void sendMessage(Message message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(message.getUserGetMessage());
        simpleMailMessage.setSubject("grgrgg");
        simpleMailMessage.setText(message.getTextMessage());
        emailSender.send(simpleMailMessage);
    }
}
