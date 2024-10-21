package ru.asteises.ozonhelperapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Value("${ozon.url}")
    private String url;

    @Value("${ozon.client_id}")
    private String clientId;

    @Value("${ozon.api-key}")
    private String apiKey;

    @Bean
    RestClient restClient() {
        return RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Client-Id", clientId)
                .defaultHeader("Api-Key", apiKey)
                .build();
    }

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
