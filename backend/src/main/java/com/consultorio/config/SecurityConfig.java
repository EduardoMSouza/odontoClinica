package com.consultorio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Lista de endpoints públicos do Swagger
    private static final String[] SWAGGER_WHITELIST = {
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            // -- SpringDoc
            "/springdoc/**",
            "/webjars/**",
            "/swagger-resources/**",
            "/swagger-resources",
            "/configuration/ui",
            "/configuration/security",
            // -- API Docs
            "/api-docs/**",
            "/api-docs.yaml",
            "/api-docs"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Configura CORS  
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para APIs REST  
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso público aos endpoints da API  
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers(SWAGGER_WHITELIST).permitAll()
                        .requestMatchers("/pacientes/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Se usar Swagger  
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated() // Todas as outras requisições precisam de autenticação  
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin()) // Permite iframe da mesma origem  
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:3000",      // React dev server
                "http://127.0.0.1:3000",      // React dev server (alternativo)
                "http://localhost:3001",      // Outra porta do React
                "https://localhost:3000",     // HTTPS local
                "https://127.0.0.1:3000",     // HTTPS local alternativo
                "http://localhost:8080",      // Seu próprio backend (para testes)
                "http://localhost:5173",      // Vite dev server
                "https://localhost:5123",     // ⭐️ ADICIONE ESTA LINHA - origem do seu frontend
                "chrome-extension://*",       // Extensões do Chrome (como Postman antigo)
                "moz-extension://*",          // Extensões do Firefox
                "postman://*"                 // Postman desktop app
                // REMOVA O "*" - não é compatível com allowCredentials=true
        ));
        configuration.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH"
        ));
        configuration.setAllowedHeaders(Arrays.asList(
                "Authorization",
                "Content-Type",
                "Accept",
                "Origin",
                "X-Requested-With",
                "Access-Control-Request-Method",
                "Access-Control-Request-Headers"
        ));
        configuration.setExposedHeaders(Arrays.asList(
                "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials"
        ));
        configuration.setAllowCredentials(false);  // Apenas para testes, use true para autenticação e afins
        configuration.setAllowedOrigins(Arrays.asList("*")); //apenas para testes, apague depois
        configuration.setMaxAge(3600L); // Cache por 1 hora  

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}