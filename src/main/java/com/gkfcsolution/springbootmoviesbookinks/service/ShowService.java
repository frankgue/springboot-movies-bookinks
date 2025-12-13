package com.gkfcsolution.springbootmoviesbookinks.service;

import com.gkfcsolution.springbootmoviesbookinks.dto.ShowDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 2025 at 21:06
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 21:06
 */
public interface ShowService {
    Show createShow(ShowDTO showDTO);
    List<Show> getAllShows();
    List<Show> getShowsByMovie( Long id);
    List<Show> getShowsByTheater( Long id);
    Show updateShow(long id, ShowDTO showDTO);
    void deleteShow(long id);
}
