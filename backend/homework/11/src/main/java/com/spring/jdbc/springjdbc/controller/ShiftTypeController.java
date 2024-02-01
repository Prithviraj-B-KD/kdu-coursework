package com.spring.jdbc.springjdbc.controller;

import com.spring.jdbc.springjdbc.dto.ShiftTypeDTO;
import com.spring.jdbc.springjdbc.service.ShiftTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShiftTypeController {
    private final ShiftTypeService shiftTypeService;

    @Autowired
    public ShiftTypeController(ShiftTypeService service) {
        this.shiftTypeService = service;
    }

    @PostMapping("/shift-type/add")
    public ResponseEntity<String> addShiftType(@RequestBody ShiftTypeDTO shiftTypeDTO) {
        try {
//            log.info(shiftTypeRequest.toString());
            if(shiftTypeService.addShiftType(shiftTypeDTO))
                return ResponseEntity.ok("Successfully added Shift Type.");

            else  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to add shift type");

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
