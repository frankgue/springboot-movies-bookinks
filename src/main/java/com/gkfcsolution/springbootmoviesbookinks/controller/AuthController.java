package com.gkfcsolution.springbootmoviesbookinks.controller;

import com.gkfcsolution.springbootmoviesbookinks.dto.LoginRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.dto.LoginResponseDTO;
import com.gkfcsolution.springbootmoviesbookinks.dto.RegisterRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;
import com.gkfcsolution.springbootmoviesbookinks.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/registernormaluser")
    public ResponseEntity<User> registerNormalUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return new ResponseEntity<>(authenticationService.registerNormalUser(registerRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<>(authenticationService.login(loginRequestDTO), HttpStatus.CREATED);
    }


}
