package com.gkfcsolution.springbootmoviesbookinks.repository;

import com.gkfcsolution.springbootmoviesbookinks.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 17:20
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 17:20
 */
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    Optional<List<Theater>> findByTheaterLocation(String location);
}
