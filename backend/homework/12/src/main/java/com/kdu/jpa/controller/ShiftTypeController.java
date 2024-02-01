package com.kdu.jpa.controller;

import com.kdu.jpa.dto.ShiftTypeDTO;
import com.kdu.jpa.dto.TenantDTO;
import com.kdu.jpa.entity.ShiftType;
import com.kdu.jpa.entity.Tenant;
import com.kdu.jpa.mapper.ShiftTypeMapper;
import com.kdu.jpa.mapper.TenantMapper;
import com.kdu.jpa.service.ShiftTypeService;
import com.kdu.jpa.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftTypeController {
    @Autowired
    ShiftTypeService shiftTypeService;

    @Autowired
    ShiftTypeMapper shiftTypeMapper;

    @PostMapping("/shiftType")
    public ResponseEntity<String> saveShiftType(@RequestBody ShiftTypeDTO shiftTypeDTO){
        ShiftType shiftType = shiftTypeMapper.mapShiftTypeDTO(shiftTypeDTO);
        shiftTypeService.saveshiftType(shiftType);
        return new ResponseEntity<>("Shift Type Saved!", HttpStatus.CREATED);
    }
}
