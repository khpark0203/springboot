package com.example.demo.client;

import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.config.WebClientConfig;

public class GoarchClient {
    private WebClient client;
    private String baseUrl = "http://localhost:8000";

    public GoarchClient() {
        this.client = new WebClientConfig(this.baseUrl).getClient();
    }

    public String getUsers() {
        return this.client.get()
                          .uri("/api/v1/users")
                          .retrieve()
                          .bodyToMono(String.class)
                          .block();
    }
}