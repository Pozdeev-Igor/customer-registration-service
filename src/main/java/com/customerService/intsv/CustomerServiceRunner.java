package com.customerService.intsv;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
        @Server( url = "https://customer-registration-service-production.up.railway.app", description = "web"),
        @Server(url = "http://localhost:8080")
})
public class CustomerServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceRunner.class, args);
    }

}

