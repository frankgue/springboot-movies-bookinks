package com.gkfcsolution.springbootmoviesbookinks.mapper;

import com.gkfcsolution.springbootmoviesbookinks.dto.TheaterDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Theater;

/**
 * Created on 2025 at 16:20
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 16:20
 */
public class TheaterMapper {

    public static Theater toTheater(TheaterDTO theaterDTO){
        return Theater.builder()
                .theaterName(theaterDTO.getTheaterName())
                .theaterCapacity(theaterDTO.getTheaterCapacity())
                .theaterLocation(theaterDTO.getTheaterLocation())
                .theaterScreenType(theaterDTO.getTheaterScreenType())
                .build();
    }

    public static TheaterDTO toTheaterDTO(Theater theater){
        return TheaterDTO.builder()
                .theaterCapacity(theater.getTheaterCapacity())
                .theaterLocation(theater.getTheaterLocation())
                .theaterName(theater.getTheaterName())
                .theaterScreenType(theater.getTheaterScreenType())
                .build();
    }
}
