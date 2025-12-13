package com.gkfcsolution.springbootmoviesbookinks.service;

import com.gkfcsolution.springbootmoviesbookinks.dto.LoginRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.dto.LoginResponseDTO;
import com.gkfcsolution.springbootmoviesbookinks.dto.RegisterRequestDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;

/**
 * Created on 2025 at 20:33
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 13/12/2025
 * @time 20:33
 */
public interface AuthenticationService {
    User registerNormalUser(RegisterRequestDTO registerRequestDTO);
    User registerAdminUser(RegisterRequestDTO registerRequestDTO);
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
