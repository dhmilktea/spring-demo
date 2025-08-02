package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final UserMapper mapper;
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendSimpleEmail() {
        Long userId = 10L;
        User user = mapper.findById(userId);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setSubject("Title");
        mailSender.send(msg);
    }

    public void sendTemplateEmail() throws MessagingException {
        Long userId = 10L;
        User user = mapper.findById(userId);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        msgHelper.setTo(user.getEmail());
        msgHelper.setSubject("Title");
        msgHelper.setText(setContext("abc", "email"));
        mailSender.send(mimeMessage);
    }

    public String setContext(String code, String type) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process(type, context);
    }

}