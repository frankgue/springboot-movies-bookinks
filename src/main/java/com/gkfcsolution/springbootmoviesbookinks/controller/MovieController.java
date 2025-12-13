package com.gkfcsolution.springbootmoviesbookinks.controller;

import com.gkfcsolution.springbootmoviesbookinks.dto.MovieDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Movie;
import com.gkfcsolution.springbootmoviesbookinks.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 15:11
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 15:11
 */
@RestController
@RequestMapping("/api/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/addmovie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.addMovie(movieDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/getmoviesbygenre")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@RequestParam String genre){
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/getmoviesbylanguage")
    public ResponseEntity<List<Movie>> getMoviesByLanguage(@RequestParam String language){
        return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
    }

    @GetMapping("/getmoviesbytitle")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@RequestParam String title){
        return ResponseEntity.ok(movieService.getMoviesByTitle(title));
    }

    @PutMapping("/updatemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.updateMovie(id, movieDTO));
    }

    @DeleteMapping("/deletemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }

}
