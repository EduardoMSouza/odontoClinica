package com.consultorio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;



@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Servidor de Desenvolvimento");

        Server prodServer = new Server();
        prodServer.setUrl("https://consultorio-api.com");
        prodServer.setDescription("Servidor de Produção");

        Contact contact = new Contact();
        contact.setEmail("contato@consultorio.com");
        contact.setName("Consultório Odontológico");
        contact.setUrl("https://consultorio.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API Consultório Odontológico")
                .version("1.0")
                .contact(contact)
                .description("API para gerenciamento de pacientes, fichas médicas e responsáveis do consultório odontológico.")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }
}