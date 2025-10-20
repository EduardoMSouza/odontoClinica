package com.consultorio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${spring.application.name:Consultório Odontológico API}")
    private String applicationName;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Consultório Odontológico API")
                        .description("""
                            ## API completa para sistema de gerenciamento de consultório odontológico
                            
                            ### 📋 Funcionalidades:
                            - **Gestão de Pacientes** - Cadastro e consulta de pacientes
                            - **Fichas Médicas** - Histórico médico completo dos pacientes
                            - **Agendamentos** - Controle de consultas e horários
                            - **Prontuários** - Registros clínicos detalhados
                            
                            ### 🛠️ Tecnologias:
                            - Java 17
                            - Spring Boot 3.3.5
                            - MySQL
                            - Spring Data JPA
                            - Spring Security
                            
                            ### 📚 Documentação:
                            - Esta documentação é gerada automaticamente com SpringDoc OpenAPI 3.0
                            - Todos os endpoints podem ser testados diretamente aqui
                            """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Suporte Consultório")
                                .email("suporte@consultorio.com")
                                .url("https://consultorio.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor de Desenvolvimento Local"),
                        new Server()
                                .url("https://api.consultorio.com")
                                .description("Servidor de Produção")
                ))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}