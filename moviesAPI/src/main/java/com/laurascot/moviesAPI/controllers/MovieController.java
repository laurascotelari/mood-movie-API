package com.laurascot.moviesAPI.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

import com.laurascot.moviesAPI.entitys.Movie;
import com.laurascot.moviesAPI.repositorys.MovieRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MovieController {
    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieRepository repository;
    private List<Movie> movies;

    public MovieController(){}


    @GetMapping("/")
    public String getWelcome() {
        return "Welcome to the MoodMovieApi!";
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @GetMapping("/start-database")
    public String startDatabase() {
        log.info("\ninsertMovie------------------------------------\n\n\n");
        repository.save(new Movie("Aftersun", 2022, Arrays.asList("sad", "cult", "philosophical")));
        repository.save(new Movie("Pierrot Le Fou", 1965, Arrays.asList("sad", "cult", "crime", "romance")));
        repository.save(new Movie("Evil does not Exist", 2023, Arrays.asList("sad", "cult", "philosophical")));
        repository.save(new Movie("My Blueberry Nights", 2007, Arrays.asList("comedy", "cult", "philosophical", "romance")));
        repository.save(new Movie("Green Book", 2018, Arrays.asList("documentary", "cult", "philosophical", "comedy")));
        repository.save(new Movie("Coerência", 2013, Arrays.asList("sci-fi", "cult", "philosophical", "mystery", "thriller")));
        repository.save(new Movie("Curiosa", 2022, Arrays.asList("romance", "cult")));
        repository.save(new Movie("O Lagosta", 2015, Arrays.asList("comedy", "cult", "philosophical", "romance", "sci-fi", "thriller")));
        return "Banco preenchido com sucesso!";
    }

    //TO-DO
    @GetMapping("/movies-by-mood")
    public List<Movie> getMoviesByMood(@RequestParam(value = "mood") String mood) {
        return movies.stream().filter(movie -> movie.getMood().contains(mood))
                              .collect(Collectors.toList());
    }

    @GetMapping("/delete-movies")
    public String deleteMovies(){
        repository.deleteAll();
        return "Todos os filmes foram deletados!";
    }
    
    @GetMapping("/movie")
    public Movie getMovieByName(@RequestParam String name) {
        return repository.findByName(name);
    }
    
    
    @PostMapping("/newMovie")
    public ResponseEntity<Movie> postMethodName(@RequestBody Movie newMovie) {
        Movie savedMovie = repository.save(newMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/id/{id}")
    public String deleteById(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "O filme foi deletado";
    }

    @DeleteMapping("delete/name/{name}")
    public String deleteByName(@PathVariable("name") String name){
        repository.deleteByName(name);
        return String.format("O filme %s foi deletado", name);
    }


    
    
}
