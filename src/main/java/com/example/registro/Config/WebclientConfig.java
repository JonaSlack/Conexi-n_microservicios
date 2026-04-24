package com.example.registro.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfig {

    @Bean
    public WebClient hospitalWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }
}