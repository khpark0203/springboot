package com.example.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.demo.client.message.GoarchClientMessage.GoarchUserResponse;
import com.example.demo.config.WebClientConfig;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.InternalServerException;
import com.example.demo.exception.NotFoundException;

@Component
public class GoarchClient extends WebClientConfig {
    
    public GoarchClient(@Value("${external.goarch.baseurl}") String baseUrl) {
        super(baseUrl);
    }
    
    public List<GoarchUserResponse> getUsers() {
        try {
            return this.client.get()
                              .uri("/api/v1/users")
                              .accept(MediaType.APPLICATION_JSON)
                              .retrieve()
                              .bodyToFlux(GoarchUserResponse.class)
                              .collectList()
                              .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode().is5xxServerError()) {
                throw new InternalServerException(ErrorMessage.CLIENT_INTERNAL_ERROR);
            } else if (e.getStatusCode().is4xxClientError()) {
                throw new NotFoundException(ErrorMessage.NOT_FOUND);
            }
            throw new InternalServerException(ErrorMessage.INTERNAL_ERROR);
        } catch (WebClientException e) {
            throw new InternalServerException(ErrorMessage.INTERNAL_ERROR);
        }
    }
}