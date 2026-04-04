package com.sis414.tarea;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")

public class hola {
    @GetMapping
    public String holamundo(){
        return "chambeando y viviendo la vida :v";
    }
}