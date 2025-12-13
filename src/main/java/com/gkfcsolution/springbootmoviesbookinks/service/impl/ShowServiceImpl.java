package com.gkfcsolution.springbootmoviesbookinks.service.impl;

import com.gkfcsolution.springbootmoviesbookinks.dto.ShowDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Booking;
import com.gkfcsolution.springbootmoviesbookinks.entity.Movie;
import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import com.gkfcsolution.springbootmoviesbookinks.entity.Theater;
import com.gkfcsolution.springbootmoviesbookinks.exception.MovieException;
import com.gkfcsolution.springbootmoviesbookinks.exception.ShowException;
import com.gkfcsolution.springbootmoviesbookinks.exception.TheaterException;
import com.gkfcsolution.springbootmoviesbookinks.repository.MovieRepository;
import com.gkfcsolution.springbootmoviesbookinks.repository.ShowRepository;
import com.gkfcsolution.springbootmoviesbookinks.repository.TheaterRepository;
import com.gkfcsolution.springbootmoviesbookinks.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 21:06
 * File: ShowServiceImpl.java.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 21:06
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    @Override
    public Show createShow(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId()).orElseThrow(() -> new MovieException("Movie not found with id: " + showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId()).orElseThrow(() -> new TheaterException("Theater not found with id: " + showDTO.getTheaterId()));

        Show show = Show.builder()
                .showTime(showDTO.getShowTime())
                .price(showDTO.getPrice())
                .movie(movie)
                .theater(theater)
                .build();

        return showRepository.save(show);
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @Override
    public List<Show> getShowsByMovie(Long id) {
        Optional<List<Show>> optionalShows = showRepository.findByMovieId(id);
        if (optionalShows.isPresent()){
            return optionalShows.get();
        }
        throw new ShowException("No shows available for movie with id: " + id);
    }

    @Override
    public List<Show> getShowsByTheater(Long id) {
        Optional<List<Show>> optionalShows = showRepository.findByTheaterId(id);
        if (optionalShows.isPresent()){
            return optionalShows.get();
        }
        throw new ShowException("No shows available for theater with id: " + id);
    }

    @Override
    public Show updateShow(long id, ShowDTO showDTO) {
        Show show = showRepository.findById(id).orElseThrow(() -> new SecurityException("Show not found with id: " + id));
        Movie movie = movieRepository.findById(showDTO.getMovieId()).orElseThrow(() -> new MovieException("Movie not found with id: " + showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId()).orElseThrow(() -> new TheaterException("Theater not found with id: " + showDTO.getTheaterId()));

        show.setShowTime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice());
        show.setMovie(movie);
        show.setTheater(theater);

        return showRepository.save(show);
    }

    @Override
    public void deleteShow(long id) {
        if (!showRepository.existsById(id)){
            throw new ShowException("Show not found with id: " + id);
        }
        List<Booking> bookings = showRepository.findById(id).get().getBookings();
        if (bookings != null && !bookings.isEmpty()){
            throw new ShowException("Cannot delete show with id: " + id + " as there are existing bookings.");
        }
        showRepository.deleteById(id);
    }
}
