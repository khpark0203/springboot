package com.example.demo.config;

import reactor.netty.http.client.HttpClient;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebClientConfig {
    private WebClient client;
    private HttpClient httpClient = HttpClient.create()
                                              .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                                              .responseTimeout(Duration.ofMillis(5000))
                                              .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                              .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

    public WebClientConfig(String baseUrl) {
        this.client = WebClient.builder()
                               .clientConnector(new ReactorClientHttpConnector(this.httpClient))
                               .baseUrl(baseUrl)
                               .build();
    }
}
