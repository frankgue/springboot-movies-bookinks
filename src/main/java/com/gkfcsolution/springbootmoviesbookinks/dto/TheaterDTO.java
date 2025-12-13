package com.gkfcsolution.springbootmoviesbookinks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 17:17
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 17:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterDTO {
    private Long id;
    private String theaterName;
    private String theaterLocation;
    private Integer theaterCapacity;
    private String theaterScreenType;
}
