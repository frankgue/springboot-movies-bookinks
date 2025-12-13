package com.gkfcsolution.springbootmoviesbookinks.dto;

import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Created on 2025 at 15:15
 * File: MovieDTO.java.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 15:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {
    private Long id;
    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;
    private String language;
}
