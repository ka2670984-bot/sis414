package com.sis414.tarea;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/peliculas")
public class tarea2 {

    static class Pelicula {
        public String nombre;
        public String prota;
        public String duracion;
    }

    ArrayList<Pelicula> peliculas = new ArrayList<>();

    @GetMapping
    public String getAll() {
        String texto = "";
        for (int i = 0; i < peliculas.size(); i++) {
            texto += "Nombre: " + peliculas.get(i).nombre + "\n";
            texto += "Prota: " + peliculas.get(i).prota + "\n";
            texto += "Duracion: " + peliculas.get(i).duracion + "\n\n";
        }
        return texto.isEmpty() ? "No hay peliculas" : texto;
    }

    @PostMapping
    public String agregar(@RequestBody Pelicula p) {
        peliculas.add(p);
        return "Pelicula agregada: " + p.nombre;
    }
}
