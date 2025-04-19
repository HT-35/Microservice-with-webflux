package com.example.service1.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class Service2Client {

	private final WebClient webClient;

	public Service2Client(WebClient.Builder webClientBuilder,
			@Value("${service2.url:http://localhost:8082}") String service2Url) {
		this.webClient = webClientBuilder.baseUrl(service2Url).build();
	}

	public Mono<String> getOrderInfo(String productId) {
		return webClient.get()
				.uri("/orders/info/{productId}", productId)
				.retrieve()
				.bodyToMono(String.class);
	}
}