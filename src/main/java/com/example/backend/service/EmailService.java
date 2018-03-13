package com.example.backend.service;

import com.example.webapp.domain.frontend.FeedbackPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    public void sendGenericEmailMessage(SimpleMailMessage message);



}
