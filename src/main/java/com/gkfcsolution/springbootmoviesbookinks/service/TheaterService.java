package com.gkfcsolution.springbootmoviesbookinks.service;

import com.gkfcsolution.springbootmoviesbookinks.dto.TheaterDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Theater;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 2025 at 17:20
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 17:20
 */
public interface TheaterService {
    Theater addTheater(TheaterDTO theaterDTO);
    List<Theater> getTheaterByLocation(String location);
    Theater updateTheater( Long id, TheaterDTO theaterDTO);
    void deleteTheater(Long id);
}
