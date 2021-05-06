package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Value("Perfil ativo: ${spring.profiles.active:N/A}. Olá página vazia!")
    private String appMessage;

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/msg")
    public String getAppMessage() {
        return appMessage;
    }
}
