package com.exampleSpringBoot.springBootFirstApiRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping
    public String getPrueba(){
        return "Hola Mundo";
    }
}
