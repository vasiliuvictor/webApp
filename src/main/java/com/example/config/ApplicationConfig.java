package com.example.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.backend.persistance.repositories")
@EntityScan(basePackages = "com.example.backend.persistance.domain.backend")
@EnableTransactionManagement
@PropertySource("file:///${user.home}/Desktop/Bootstrap app/webApp/application-common.properties")
public class ApplicationConfig {
}
