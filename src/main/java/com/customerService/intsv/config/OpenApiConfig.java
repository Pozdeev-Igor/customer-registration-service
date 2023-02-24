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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicLibraryApi() {
        return GroupedOpenApi.builder()
                .group("customerService.intsv")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public OpenAPI customOpenApi(
            @Value("customerService.intsv") String appName,
            @Value("customerService - to do service") String appDescription,
            @Value("0.0.1-SNAPSHOT}") String appVersion) {
        return new OpenAPI().info(new Info().title("Applecation API")
                        .version(appVersion)
                        .description(appDescription)
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .contact(new Contact().name("Marsel")
                                .email("test@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:8080")
                        .description("Dev service"),new Server().url("http://localhost:8082")
                        .description("Beta Service")));
    }

}
