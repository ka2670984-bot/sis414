package com.sis414.tarea;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class hello {
@GetMapping("/hello")
    public String Gethello() {
        return " hello";
    }
}
