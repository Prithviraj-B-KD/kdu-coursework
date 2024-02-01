package com.spring.jdbc.springjdbc.controller;

import com.spring.jdbc.springjdbc.dto.ShiftTypeDTO;
import com.spring.jdbc.springjdbc.dto.ShiftUserDTO;
import com.spring.jdbc.springjdbc.service.ShiftUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShiftUserController {
    private final ShiftUserService userService;

    @Autowired
    public ShiftUserController(ShiftUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/shift-user/add")
    public ResponseEntity<String> addShiftUser(@RequestBody ShiftUserDTO shiftUserDTO) {
        try {
           if( userService.addShiftUser(shiftUserDTO)) {
               return ResponseEntity.ok("Shift user added successfully.");
           } else {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add shift user.");
           }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
