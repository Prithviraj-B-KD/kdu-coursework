package com.kdu.jpa.controller;

import com.kdu.jpa.dto.ShiftDTO;
import com.kdu.jpa.entity.Shift;
import com.kdu.jpa.mapper.ShiftMapper;
import com.kdu.jpa.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftController {

    @Autowired
    ShiftService shiftservice;

    @Autowired
    ShiftMapper shiftMapper;

    @PostMapping("/shift")
    public ResponseEntity<String> saveShift(@RequestBody ShiftDTO shiftDTO){
        Shift shift=shiftMapper.mapShiftDTO(shiftDTO);
        shiftservice.saveShift(shift);
        return new ResponseEntity<>("Shift Saved!", HttpStatus.CREATED);
    }

}
