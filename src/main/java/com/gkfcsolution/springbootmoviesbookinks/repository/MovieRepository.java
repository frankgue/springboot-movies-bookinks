package com.gkfcsolution.springbootmoviesbookinks.repository;

import com.gkfcsolution.springbootmoviesbookinks.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 15:11
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 15:11
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<List<Movie>> findByGenre(String genre);
    Optional<List<Movie>> findByLanguage(String language);
    Optional<List<Movie>> findByName(String title);
}
