package com.classgen.classgen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll() // Autoriser Swagger
                        .anyRequest().permitAll() // Permettre toutes les requêtes
                )
                .csrf(csrf -> csrf.disable()); // Désactiver CSRF si nécessaire

        return http.build();
    }
}




