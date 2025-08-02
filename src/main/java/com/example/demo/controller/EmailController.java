package com.example.demo.controller;

import com.example.demo.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public void sendEmail() {
        emailService.sendSimpleEmail();
    }

    @PostMapping("/template")
    public void sendTemplateEmail() {
        try {
            emailService.sendTemplateEmail();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}