package com.example.config;


import com.example.backend.service.EmailService;
import com.example.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/Desktop/Bootstrap app/webApp/application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

}
