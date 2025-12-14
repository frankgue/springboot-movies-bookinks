package com.gkfcsolution.springbootmoviesbookinks.mapper;

import com.gkfcsolution.springbootmoviesbookinks.dto.MovieDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Movie;

/**
 * Created on 2025 at 16:20
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 16:20
 */
public class MovieMapper {

    public static Movie toMovie(MovieDTO movieDTO){
        return Movie.builder()
                .name(movieDTO.getName())
                .description(movieDTO.getDescription())
                .genre(movieDTO.getGenre())
                .duration(movieDTO.getDuration())
                .releaseDate(movieDTO.getReleaseDate())
                .language(movieDTO.getLanguage())
                .build();
    }

    public static MovieDTO toMovieDTO(Movie movie){
        return MovieDTO.builder()
                .name(movie.getName())
                .description(movie.getDescription())
                .genre(movie.getGenre())
                .duration(movie.getDuration())
                .releaseDate(movie.getReleaseDate())
                .language(movie.getLanguage())
                .build();
    }
}
