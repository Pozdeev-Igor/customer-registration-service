package com.customerService.intsv.controller;

import com.customerService.intsv.entity.Client;
import com.customerService.intsv.repository.ClientRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ClientRepo clientRepo;

    public TestController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @GetMapping("/test")
    public String test(){

        return "WELL,WELL,WELL...";
    }

}
