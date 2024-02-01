package com.kdu.jpa.controller;

import com.kdu.jpa.dto.ShiftDTO;
import com.kdu.jpa.dto.TenantDTO;
import com.kdu.jpa.entity.Shift;
import com.kdu.jpa.entity.Tenant;
import com.kdu.jpa.mapper.ShiftMapper;
import com.kdu.jpa.mapper.TenantMapper;
import com.kdu.jpa.service.ShiftService;
import com.kdu.jpa.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {
    @Autowired
    TenantService tenantService;

    @Autowired
    TenantMapper tenantMapper;

    @PostMapping("/tenant")
    public ResponseEntity<String> savetenant(@RequestBody TenantDTO tenantDTO){
        Tenant tenant=tenantMapper.mapTenantDTO(tenantDTO);
        tenantService.saveTenant(tenant);
        return new ResponseEntity<>("Tenant Saved!", HttpStatus.CREATED);
    }
}
