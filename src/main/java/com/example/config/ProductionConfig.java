package com.example.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/Desktop/Bootstrap app/webApp/application-prod.properties")
public class ProductionConfig {


}
