package com.customerService.intsv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public void getStartPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }
}
