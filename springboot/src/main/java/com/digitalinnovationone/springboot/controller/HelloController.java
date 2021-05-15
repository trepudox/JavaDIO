package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@PropertySource("classpath:res.properties") // escolhe de onde o @Value vai tirar os valores
public class HelloController {

    @Value("Perfil ativo: ${spring.profiles.active:N/A}. Olá página vazia!") // @Value insere o valor na variavel
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
