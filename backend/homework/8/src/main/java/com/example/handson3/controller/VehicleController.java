package com.example.handson3.controller;

import com.example.handson3.dto.VehicleDTO;
import com.example.handson3.dto.VehicleDTOMapper;
import com.example.handson3.model.Vehicle;
import com.example.handson3.service.FactoryService;
import com.example.handson3.util.LogBack;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private FactoryService factoryService;

    @Autowired
    VehicleController(FactoryService factoryService){
        this.factoryService = factoryService;
    }
    @PostMapping
    public ResponseEntity<String> addVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
        factoryService.addVehicle(vehicleDTO);
        return ResponseEntity.ok("SuccessFully Added.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id){
        Vehicle vehicle = factoryService.getVehicle(id);
        VehicleDTO vehicleDTO = VehicleDTOMapper.vehicleToDTO(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicleByID(@PathVariable Long id,@Valid @RequestBody VehicleDTO vehicleDTO){
        factoryService.updateVehicle(id,vehicleDTO);
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletelVehicleById(@PathVariable Long id){
        factoryService.deleteVehicle(id);
        return ResponseEntity.ok("successfully deleted");
    }


}
