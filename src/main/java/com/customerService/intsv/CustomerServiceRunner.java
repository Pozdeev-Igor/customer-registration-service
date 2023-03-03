package com.customerService.intsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceRunner.class, args);
    }

}

