package com.gkfcsolution.springbootmoviesbookinks.controller;

import com.gkfcsolution.springbootmoviesbookinks.dto.RegisterRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;
import com.gkfcsolution.springbootmoviesbookinks.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 20:27
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 13/12/2025
 * @time 20:27
 */
@RestController
@RequestMapping("/api/admin")
@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final AuthenticationService authenticationService;
    @PostMapping("/registeradminuser")
    public ResponseEntity<User> registerAdminUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return new ResponseEntity<>(authenticationService.registerAdminUser(registerRequestDTO), HttpStatus.CREATED);
    }
}
