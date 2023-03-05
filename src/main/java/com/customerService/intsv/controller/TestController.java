package com.customerService.intsv.controller;

import com.customerService.intsv.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final UserRepository userRepo;

    public TestController(UserRepository clientRepo) {
        this.userRepo = clientRepo;
    }

    @GetMapping("/test")
    public String test(){

        return "WELL,WELL,WELL...";
    }

}
