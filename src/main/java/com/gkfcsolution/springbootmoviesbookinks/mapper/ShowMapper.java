package com.gkfcsolution.springbootmoviesbookinks.mapper;

import com.gkfcsolution.springbootmoviesbookinks.dto.ShowDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Show;

/**
 * Created on 2025 at 20:14
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 20:14
 */
public class ShowMapper {

    public static Show toShow(ShowDTO showDTO){
        return Show.builder()
                .showTime(showDTO.getShowTime())
                .price(showDTO.getPrice())
                .build();
    }

    public static ShowDTO toShowDTO(Show show){
        return ShowDTO.builder()
                .price(show.getPrice())
                .showTime(show.getShowTime())
                .movieId(show.getMovie().getId())
                .theaterId(show.getTheater().getId())
                .build();
    }
}
