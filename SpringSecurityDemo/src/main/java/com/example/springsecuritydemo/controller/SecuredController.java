package com.example.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
    @GetMapping("/secured/hello")
    public String securedHello(){
        return "Hello, This is secured page!";
    }
}
