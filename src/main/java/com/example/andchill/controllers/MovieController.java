package com.example.andchill.controllers;

import com.example.andchill.CustomizedResponse;
import com.example.andchill.models.Movie;
import com.example.andchill.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService service;

    // Create an endpoint that retrieves everything.
    @GetMapping("/movies")
    public ResponseEntity getAllMovies() {
        var customizedResponse = new CustomizedResponse("GET all movies", service.getMovies());
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    // Create an endpoint that retrieves  all the TV shows in the database.
    @GetMapping("/tv")
    public ResponseEntity getAllTV() {
        var customizedResponse = new CustomizedResponse("GET all TV", service.getTV());
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    // Create an endpoint that retrieves  all the Films in the database.
    @GetMapping("/films")
    public ResponseEntity getAllFilms() {
        var customizedResponse = new CustomizedResponse("GET all films", service.getFilms());
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    // Create an endpoint that will retrieve the featured movies/tv - specify movies/tv in query
    @GetMapping("/featured")
    public ResponseEntity getFilmsByFeaturedName(@RequestParam(value="featured") String type) {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("GET featured by type: " + type, service.getFeaturedFilms(type));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


    @GetMapping("/movies/genre")
    public ResponseEntity getMoviesByGenre(@RequestParam(value="genre") String genre) {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("GET movies by genre", service.getMoviesByGenre(genre));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/movies/title")
    public ResponseEntity getMoviesByTitle(@RequestParam(value="title") String title) {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("GET movies by title", service.getMoviesByTitle(title));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/movies/id/{id}")
    public ResponseEntity getMovie(@PathVariable("id") String id) {

        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("Get movie with id " + id , Collections.singletonList(service.getMovieById(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/movies", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        System.out.println("POST movie: " + movie);
        service.addToMovies(movie);
        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @PutMapping(value = "/movies/id/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity putMovie(@PathVariable("id") String id, @RequestBody Movie newMovie) {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("Update movie with id "+id, Collections.singletonList(service.editMovie(id, newMovie)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @DeleteMapping("/movies/id/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") String id) {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("Delete movie with id " + id , Collections.singletonList(service.deleteMovie(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        System.out.println(customizedResponse.getMessage());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    public MovieController() {
        super();
    }
}
