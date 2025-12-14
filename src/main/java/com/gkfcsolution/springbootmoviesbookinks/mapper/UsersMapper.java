package com.gkfcsolution.springbootmoviesbookinks.mapper;

import com.gkfcsolution.springbootmoviesbookinks.dto.UserDTO;
import com.gkfcsolution.springbootmoviesbookinks.entity.User;

/**
 * Created on 2025 at 20:14
 * File: null.java
 * Project: springboot-movies-bookinks
 *
 * @author Frank GUEKENG
 * @date 12/12/2025
 * @time 20:14
 */
public class UsersMapper {

    public static User toUser(UserDTO userDTO){
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .roles(userDTO.getRoles())
                .build();
    }

    public static UserDTO toUserDTO(User user){
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
}
