package com.filmratings.filmratings.config;  // Le package doit correspondre à la structure de ton projet

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
                registry.addMapping("/api/**")  // Autoriser toutes les routes qui commencent par /api/
                        .allowedOrigins("http://localhost:4200")  // Autoriser l'origine localhost:4200 (frontend Angular)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Autoriser ces méthodes HTTP
                        .allowedHeaders("*")  // Autoriser tous les en-têtes
                        .allowCredentials(true);  // Autoriser les cookies/sessions si nécessaire
            }
        };
    }
}
