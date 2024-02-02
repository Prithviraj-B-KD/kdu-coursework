package com.example.assesment2.controller;

import com.example.assesment2.dto.UserRequestDTO;
import com.example.assesment2.dto.UserResponseDTO;
import com.example.assesment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserRequestDTO userDTO){
        userService.addUser(userDTO);
        return new ResponseEntity<>("User added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID userid){
        UserResponseDTO userResponseDTO= userService.getUserById(userid);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.FOUND);
    }

    @PutMapping("/user/{userid}")
    public ResponseEntity<String> updateUserById(@PathVariable UUID userid , @RequestBody UserRequestDTO userRequestDTO){
        userService.updateUserById(userRequestDTO,userid);
        return new ResponseEntity<>("Successfully Updated User",HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{userid}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID userid){
        userService.deleteUsersById(userid);
        return new ResponseEntity<>("Deleted User Successfully",HttpStatus.ACCEPTED);
    }
}
