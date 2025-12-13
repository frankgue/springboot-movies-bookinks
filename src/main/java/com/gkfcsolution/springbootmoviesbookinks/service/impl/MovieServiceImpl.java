package com.gkfcsolution.springbootmoviesbookinks.service.impl;

import com.gkfcsolution.springbootmoviesbookinks.dto.MovieDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Movie;
import com.gkfcsolution.springbootmoviesbookinks.exception.MovieException;
import com.gkfcsolution.springbootmoviesbookinks.mapper.MovieMapper;
import com.gkfcsolution.springbootmoviesbookinks.repository.MovieRepository;
import com.gkfcsolution.springbootmoviesbookinks.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 15:12
 * File: MovieServiceImpl.java.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 15:12
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    @Override
    public Movie addMovie(MovieDTO movieDTO) {
        Movie movie = MovieMapper.toMovie(movieDTO);

        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie =  movieRepository.findById(id).orElseThrow(() -> new MovieException("Movies not found for id: " + id));

        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setDuration(movieDTO.getDuration());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate());


        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        Optional<List<Movie>> movieList = movieRepository.findByGenre(genre);
        if (movieList.isEmpty()){
            return movieList.get();
        }
        throw new MovieException("Movies not found for genre: " + genre);
    }

    @Override
    public List<Movie> getMoviesByLanguage(String language) {
        Optional<List<Movie>> movieList = movieRepository.findByLanguage(language);
        if (movieList.isEmpty()){
            return movieList.get();
        }
        throw new MovieException("Movies not found for language: " + language);
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        Optional<List<Movie>> movieList = movieRepository.findByName(title);
        if (movieList.isEmpty()){
            return movieList.get();
        }
        throw new MovieException("Movies not found for title: " + title);
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie =  movieRepository.findById(id).orElseThrow(() -> new MovieException("Movies not found for id: " + id));
        movieRepository.delete(movie);
    }
}
