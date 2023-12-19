package com.WebSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.WebSocket.repository")
public class ElasticsearchConfig {
    // Configuración adicional si es necesaria
}
