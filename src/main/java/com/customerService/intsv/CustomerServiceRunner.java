package com.customerService.intsv;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
        @Server( url = "https://customer-registration-service-production-50d8.up.railway.app", description = "web")
})
public class CustomerServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceRunner.class, args);
    }

}

