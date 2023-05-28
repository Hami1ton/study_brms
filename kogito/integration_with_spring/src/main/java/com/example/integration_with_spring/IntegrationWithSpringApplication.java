package com.example.integration_with_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.integration_with_spring.**", "org.drools.**" })
public class IntegrationWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationWithSpringApplication.class, args);
	}
}
