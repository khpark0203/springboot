package com.example.demo.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Getter;
import lombok.Setter;
import reactor.netty.http.client.HttpClient;

@Getter
@Setter
@Configuration
public class WebClientConfig {
    protected WebClient client;
    private HttpClient httpClient = HttpClient.create()
                                              .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                                              .responseTimeout(Duration.ofMillis(5000))
                                              .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                              .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

    public WebClientConfig() {
        this.client = WebClient.builder()
                               .clientConnector(new ReactorClientHttpConnector(this.httpClient))
                               .build();
    }

    public WebClientConfig(String baseUrl) {
        this.client = WebClient.builder()
                               .clientConnector(new ReactorClientHttpConnector(this.httpClient))
                               .baseUrl(baseUrl)
                               .build();
    }
}
