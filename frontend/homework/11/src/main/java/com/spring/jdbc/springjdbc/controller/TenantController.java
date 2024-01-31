package com.spring.jdbc.springjdbc.controller;


import com.spring.jdbc.springjdbc.dto.TenantDTO;
import com.spring.jdbc.springjdbc.service.TenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class TenantController {
    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/tenant/add")
    public ResponseEntity<String> addTenant(@RequestBody TenantDTO tenantDTO) {
        try {
            if (tenantService.addTenant(tenantDTO)) {
                return ResponseEntity.ok("Tenant added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to add tenant");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
