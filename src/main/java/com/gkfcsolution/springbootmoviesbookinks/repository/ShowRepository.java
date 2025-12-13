package com.gkfcsolution.springbootmoviesbookinks.repository;

import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 20:59
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 20:59
 */
public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<List<Show>> findByMovieId(Long movieId);
    Optional<List<Show>> findByTheaterId(long theaterId);
}
