package com.example.integration_with_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.integration_with_spring.DrinkDecisionService.decide_drink;

@SpringBootApplication
public class IntegrationWithSpringApplication {

	public static void main(String[] args) {

		decide_drink();

		SpringApplication.run(IntegrationWithSpringApplication.class, args);
	}



}
