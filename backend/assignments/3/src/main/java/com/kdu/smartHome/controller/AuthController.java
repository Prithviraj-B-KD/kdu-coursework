package com.kdu.smartHome.controller;

import com.kdu.smartHome.DTO.UserRegisterRequest;
import com.kdu.smartHome.DTO.UserRegisterResponse;
import com.kdu.smartHome.service.UserService;
import com.kdu.smartHome.utility.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest userRegisterRequest){

        userService.registerUser(userRegisterRequest);
        String jwt = JwtTokenGenerator.generatJwtToken(userRegisterRequest.getUsername());
        return ResponseEntity.ok(UserRegisterResponse.builder()
                        .message("Successfully Added the user")
                        .token(jwt)
                .build());
    }
}
