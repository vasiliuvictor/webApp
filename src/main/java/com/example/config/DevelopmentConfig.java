package com.example.config;


import com.example.backend.service.EmailService;
import com.example.backend.service.MockEmailService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/Bootstrap app/webApp/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }


}
