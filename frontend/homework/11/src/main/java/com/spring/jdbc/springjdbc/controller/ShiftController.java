package com.spring.jdbc.springjdbc.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring.jdbc.springjdbc.dto.ShiftDTO;
import com.spring.jdbc.springjdbc.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ShiftController {
    private final ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("/shift/add")
    public ResponseEntity<String> addShift(@RequestBody ShiftDTO shiftDTO) {
        try {
            if (shiftService.addShift(shiftDTO)) {
                return ResponseEntity.ok("Shift added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add shift");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
    @GetMapping("shift/getbytenant")
    public ResponseEntity<String> getByTenant(@RequestParam @JsonDeserialize UUID tenantID) {
        try {
            List<ShiftDTO> shiftDTO = shiftService.getShift(tenantID);
            if (shiftDTO!=null) {
                return ResponseEntity.ok(shiftDTO.toString());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get shift");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
