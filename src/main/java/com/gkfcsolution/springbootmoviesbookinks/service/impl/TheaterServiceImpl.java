package com.gkfcsolution.springbootmoviesbookinks.service.impl;

import com.gkfcsolution.springbootmoviesbookinks.dto.TheaterDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Theater;
import com.gkfcsolution.springbootmoviesbookinks.exception.TheaterException;
import com.gkfcsolution.springbootmoviesbookinks.mapper.TheaterMapper;
import com.gkfcsolution.springbootmoviesbookinks.repository.TheaterRepository;
import com.gkfcsolution.springbootmoviesbookinks.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 17:21
 * File: TheaterServiceImpl.java.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 17:21
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;

    @Override
    public Theater addTheater(TheaterDTO theaterDTO) {
        Theater theater = TheaterMapper.toTheater(theaterDTO);
        return theaterRepository.save(theater);
    }

    @Override
    public List<Theater> getTheaterByLocation(String location) {
        Optional<List<Theater>> optionalTheaterList = theaterRepository.findByTheaterLocation(location);
        if (optionalTheaterList.isPresent()){
            return optionalTheaterList.get();
        }
        throw new TheaterException("Theaters not found for location: " + location);
    }

    @Override
    public Theater updateTheater(Long id, TheaterDTO theaterDTO) {

        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new TheaterException("Theaters not found with id: " + id));

        theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());

        return theaterRepository.save(theater);
    }

    @Override
    public void deleteTheater(Long id) {

        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new TheaterException("Theaters not found with id: " + id));
        theaterRepository.delete(theater);
    }
}
