package com.gkfcsolution.springbootmoviesbookinks.service.impl;

import com.gkfcsolution.springbootmoviesbookinks.dto.LoginRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.dto.LoginResponseDTO;
import com.gkfcsolution.springbootmoviesbookinks.dto.RegisterRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;
import com.gkfcsolution.springbootmoviesbookinks.repository.UserRepository;
import com.gkfcsolution.springbootmoviesbookinks.service.AuthenticationService;
import com.gkfcsolution.springbootmoviesbookinks.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2025 at 20:33
 * File: AuthenticationServiceImpl.java.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 13/12/2025
 * @time 20:33
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    //    private final JwtService jwtService;
    private final JwtUtil jwtUtil;
    @Override
    public User registerNormalUser(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_USER");

        User user = User.builder()
                .username(registerRequestDTO.getUsername())
                .email(registerRequestDTO.getEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .roles(roles)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User registerAdminUser(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");

        User user = User.builder()
                .username(registerRequestDTO.getUsername())
                .email(registerRequestDTO.getEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .roles(roles)
                .build();

        return userRepository.save(user);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );

        String token = jwtUtil.generateToken(user);

        return LoginResponseDTO.builder()
                .jwtToken(token)
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }
}
