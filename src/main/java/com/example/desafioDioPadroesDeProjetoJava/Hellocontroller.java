package com.example.desafioDioPadroesDeProjetoJava;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @GetMapping
    private String hello(){
        return "Hello World Dio";
    }
}
