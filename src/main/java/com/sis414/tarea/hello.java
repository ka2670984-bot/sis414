package com.sis414.tarea;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class hello {

    ArrayList<String> list = new ArrayList<>();

    @GetMapping("/hello")
    public String Gethello() {
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            text = text + list.get(i);
        }
        return text;
    }
    @PostMapping("/hello")
    public String Posthello(@RequestBody String variable) {
        list.add(variable);
        return variable;
    }
}
