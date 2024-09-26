package com.kdu.smartHome.controller;


import com.kdu.smartHome.DTO.InventoryRequest;
import com.kdu.smartHome.DTO.InventoryResponse;
import com.kdu.smartHome.entity.Inventory;
import com.kdu.smartHome.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryResponse> addDeviceToInventory(@RequestBody InventoryRequest inventoryRequest){
        Inventory inventory = inventoryService.addDeviceToInventory(inventoryRequest);
        return ResponseEntity.ok(InventoryResponse.builder()
                .message("Successfully Added device to inventory")
                        .inventory(inventory)
                        .status(HttpStatus.OK)
                        .build());
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> displayInventory(){
        return ResponseEntity.ok( inventoryService.displayInventory());
    }
}
