package com.example.demo.client;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.demo.config.WebClientConfig;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.InternalServerException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Family;

public class GoarchClient extends WebClientConfig {

    private static final String BASE_URL = "http://localhost:8000";

    public GoarchClient() {
        super(BASE_URL);
    }

    public List<Family> getUsers() {
        try {
            return this.client.get()
                            .uri("/api/v1/status/500")
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(Family.class)
                            .collectList()
                            .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode().is5xxServerError()) {
                throw new InternalServerException(ErrorMessage.CLIENT_INTERNAL_ERROR);
            }
            throw new NotFoundException(ErrorMessage.NOT_FOUND);
        } catch (WebClientException e) {
            throw new NotFoundException(ErrorMessage.NOT_FOUND);
        }
    }
}