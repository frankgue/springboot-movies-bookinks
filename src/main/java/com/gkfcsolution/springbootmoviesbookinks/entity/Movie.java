package com.gkfcsolution.springbootmoviesbookinks.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 15:04
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 15:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;
    private String language;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Show> shows = new ArrayList<>();
}
