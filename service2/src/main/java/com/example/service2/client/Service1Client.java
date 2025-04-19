package com.example.service2.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class Service1Client {

	private final WebClient webClient;

	public Service1Client(WebClient.Builder webClientBuilder,
			@Value("${service1.url:http://localhost:8081}") String service1Url) {
		this.webClient = webClientBuilder.baseUrl(service1Url).build();
	}

	public Mono<String> getProductInfo(String productId) {
		return webClient.get()
				.uri("/products/{id}", productId)
				.retrieve()
				.bodyToMono(String.class);
	}
}