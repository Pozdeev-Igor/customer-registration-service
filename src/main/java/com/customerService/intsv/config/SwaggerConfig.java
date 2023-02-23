package com.customerService.intsv.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicLibraryApi() {
        return GroupedOpenApi.builder()
                .group("SpringMVCProject1_Library")
                .pathsToMatch("/people/**", "/books/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(
            @Value("${APPLICATION_NAME:SpringMVCProject1_Library}") String appName,
            @Value("${APPLICATION_DESCRIPTION:SpringMVCProject1_Library - library application}") String appDescription,
            @Value("${APPLICATION_VERSION: 0.0.1-SNAPSHOT}") String appVersion) {
        return new OpenAPI().info(new Info().title("Applecation API")
                        .version(appVersion)
                        .description(appDescription)
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .contact(new Contact().name("Marsel")
                                .email("test@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:8080")
                        .description("Dev service"), new Server().url("http://localhost:8082")
                        .description("Beta Service")));
    }
}
