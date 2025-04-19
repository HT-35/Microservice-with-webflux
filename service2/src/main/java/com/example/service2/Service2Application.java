package com.example.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Service2Application {
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}