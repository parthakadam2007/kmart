package com.example.kmart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String HomeRespose() {
        return "Welcome to Kmart API ";
    }
}


