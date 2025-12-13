package com.gkfcsolution.springbootmoviesbookinks.controller;

import com.gkfcsolution.springbootmoviesbookinks.dto.ShowDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.Show;
import com.gkfcsolution.springbootmoviesbookinks.service.ShowService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 21:05
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 21:05
 */
@RestController
@RequestMapping("/api/shows")
@Slf4j
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping("/createshow")
    public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO){
        return new ResponseEntity<>(showService.createShow(showDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getallshows")
    public ResponseEntity<List<Show>> getAllShows(){
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/getshowsbymovie/{id}")
    public ResponseEntity<List<Show>> getShowsByMovie(@PathVariable Long id){
        return ResponseEntity.ok(showService.getShowsByMovie(id));
    }

    @GetMapping("/getshowsbytheater/{id}")
    public ResponseEntity<List<Show>> getShowsByTheater(@PathVariable Long id){
        return ResponseEntity.ok(showService.getShowsByTheater(id));
    }

    @PutMapping("/updateshow/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable long id, @RequestBody ShowDTO showDTO){
        return ResponseEntity.ok(showService.updateShow(id, showDTO));
    }

    @DeleteMapping("/deleteShow/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable long id){
        showService.deleteShow(id);
        return ResponseEntity.ok().build();
    }

}
