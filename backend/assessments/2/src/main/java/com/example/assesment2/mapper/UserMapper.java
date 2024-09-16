package com.example.assesment2.mapper;

import com.example.assesment2.dto.UserRequestDTO;
import com.example.assesment2.dto.UserResponseDTO;

import com.example.assesment2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User mapUserRequestDTO(UserRequestDTO userRequestDTO){
        return User.builder()
                .fullName(userRequestDTO.getFullName())
                .email(userRequestDTO.getEmail())
                .password(passwordEncoder.encode(userRequestDTO.getPassword()))
                .role("ROLE_BASIC")
                .build();
    }
    public UserResponseDTO mapUser(User user){
        return UserResponseDTO.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();
    }
}
