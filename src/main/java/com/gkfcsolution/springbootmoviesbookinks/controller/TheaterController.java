package com.gkfcsolution.springbootmoviesbookinks.controller;

import com.gkfcsolution.springbootmoviesbookinks.dto.TheaterDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Theater;
import com.gkfcsolution.springbootmoviesbookinks.mapper.TheaterMapper;
import com.gkfcsolution.springbootmoviesbookinks.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 17:22
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 17:22
 */
@RestController
@RequestMapping("/api/theaters")
@Slf4j
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping("/addtheater")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theater> addTheater(@RequestBody TheaterDTO theaterDTO) {
        return new ResponseEntity<>(theaterService.addTheater(theaterDTO), HttpStatus.CREATED);
    }

    @GetMapping("/gettheaterbylocation")
    public ResponseEntity<List<Theater>> getTheaterByLocation(@RequestParam String location) {
        return ResponseEntity.ok(theaterService.getTheaterByLocation(location));
    }

    @PutMapping("/updatetheater/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody TheaterDTO theaterDTO){
        return ResponseEntity.ok(theaterService.updateTheater(id, theaterDTO));
    }

    @DeleteMapping("/deletetheater/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id){
        theaterService.deleteTheater(id);
        return ResponseEntity.ok().build();
    }
}
