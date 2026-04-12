package com.sis414.tarea;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public String PostHello(@RequestBody String variable)
    {
        list.add(variable);
        return  variable;
    }

    @DeleteMapping("/{id}")
    public String DeleteHello(@PathVariable long id)
    {
        return id+"";
    }

    @PutMapping("/{id}")
    public String PutHello(@RequestBody String variable, @PathVariable long id)
    {
        return "";
    }
}
