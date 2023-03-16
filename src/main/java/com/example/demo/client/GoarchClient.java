package com.example.demo.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.config.WebClientConfig;

public class GoarchClient<T> {
    private WebClient client;
    private String baseUrl = "http://localhost:8000";

    public GoarchClient() {
        this.client = new WebClientConfig(this.baseUrl).getClient();
    }

    public List<T> getUsers() {
        List<T> c = new ArrayList<>();
        return this.client.get()
                          .uri("/api/v1/users")
                          .retrieve()
                          .bodyToMono(c.getClass())
                          .block();
    }
}