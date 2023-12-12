package com.WebSocket.config;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Permite credenciales
        config.addAllowedOrigin("http://localhost:4200"); // Origen permitido
        config.addAllowedOrigin("http://172.20.10.2:4200");
        config.addAllowedOrigin("http://172.20.10.4:4200");

        // Permitir para WebSocket
        config.addAllowedOrigin("ws://localhost:4200");
        config.addAllowedOrigin("ws://172.20.10.2:4200");
        config.addAllowedOrigin("ws://172.20.10.4:4200");

        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}


