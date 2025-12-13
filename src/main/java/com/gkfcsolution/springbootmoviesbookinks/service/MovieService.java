package com.gkfcsolution.springbootmoviesbookinks.service;

import com.gkfcsolution.springbootmoviesbookinks.dto.MovieDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Movie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 2025 at 15:12
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 15:12
 */
public interface MovieService {
    Movie addMovie(MovieDTO movieDTO);
    Movie updateMovie(Long id, MovieDTO movieDTO);
    List<Movie> getAllMovies();
    List<Movie> getMoviesByGenre(String genre);
    List<Movie> getMoviesByLanguage(String language);
    List<Movie> getMoviesByTitle(String title);
    void deleteMovie(Long id);
}
