package com.sis414.tarea;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/movies")
public class movie {

    static class Movie {
        public String nombre;
        public String prota;
        public String duracion;

        public Movie(String nombre, String prota, String duracion) {
            this.nombre = nombre;
            this.prota = prota;
            this.duracion = duracion;
        }
    }
    static class MovieRequest {
        public String nombre;
        public String prota;
        public String duracion;
    }
    ArrayList<Movie> movies = new ArrayList<Movie>();
    public movie() {
        movies.add(new Movie("aladin",         "aladin",         "2h 55min"));
        movies.add(new Movie("hercules",       "hercules",       "2h 28min"));
        movies.add(new Movie("dragon ball GT", "goku",           "2h 34min"));
        movies.add(new Movie("pokemon",        "Ash Ketchum",    "2h 16min"));
        movies.add(new Movie("Parasyte",       "Shinichi Izumi", "2h 12min"));
        movies.add(new Movie("Toy Story",      "woody",          "2h 49min"));
        movies.add(new Movie("El Rey Leon",    "simba",          "1h 28min"));
        movies.add(new Movie("Kung Fu Panda",  "po",             "3h 14min"));
        movies.add(new Movie("mama coco",      "migel",          "1h 45min"));
        movies.add(new Movie("Los Increibles", "MR increible",   "3h 01min"));
        movies.add(new Movie("Spiderman",      "Peter parker",   "3h 28min"));
        movies.add(new Movie("Forrest Gump",   "Tom Hanks",      "2h 22min"));
    }
    @GetMapping
    public String getAllMovies() {
        String texto = "";
        for (int i = 0; i < movies.size(); i++) {
            texto += "Nombre: "   + movies.get(i).nombre   + "\n";
            texto += "Prota: "    + movies.get(i).prota    + "\n";
            texto += "Duracion: " + movies.get(i).duracion + "\n\n";
        }
        return texto;
    }
    @PostMapping
    public String agregarPelicula(@RequestBody MovieRequest request) {
        movies.add(new Movie(request.nombre, request.prota, request.duracion));
        return "Pelicula agregada: " + request.nombre;
    }
    @GetMapping("/{nombre}")
    public String buscarPelicula(@PathVariable String nombre) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).nombre.equals(nombre)) {
                return "Encontre la pelicula!\n"
                        + "Nombre: "   + movies.get(i).nombre   + "\n"
                        + "Prota: "    + movies.get(i).prota    + "\n"
                        + "Duracion: " + movies.get(i).duracion + "\n";
            }
        }
        return "No encontre la pelicula";
    }
}