package com.customerService.intsv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    @GetMapping("/getall")
    public String getAll() {
        return "looser";
    }
}
