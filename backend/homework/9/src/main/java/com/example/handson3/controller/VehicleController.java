package com.example.handson3.controller;

import com.example.handson3.dto.VehicleDTO;
import com.example.handson3.dto.VehicleDTOMapper;
import com.example.handson3.model.Vehicle;
import com.example.handson3.service.FactoryService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final FactoryService factoryService;

    @Autowired
    VehicleController(FactoryService factoryService){
        this.factoryService = factoryService;
    }

    /**
     *
     * @param vehicleDTO is passed to factory Service
     * @return ok message on successfully retrieved
     */
    @PostMapping
    public ResponseEntity<String> addVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) throws BadRequestException {
            factoryService.addVehicle(vehicleDTO);
            return ResponseEntity.ok("SuccessFully Added.");

    }

    /**
     *
     * @param id id of the vehicle to be searched
     * @return the vehicleDTO with id passed
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id){
        Vehicle vehicle = factoryService.getVehicle(id);

        VehicleDTO vehicleDTO = VehicleDTOMapper.vehicleToDTO(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

    /**
     *
     * @param id takes id has input and VehicleDTO
     * @return OK message on update
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicleByID(@PathVariable Long id,@Valid @RequestBody VehicleDTO vehicleDTO){
        factoryService.updateVehicle(id,vehicleDTO);
        return ResponseEntity.ok("Successfully updated");
    }

    /**
     *
     * @param id takes id has input
     * @return OK message on delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleById(@PathVariable Long id){
        factoryService.deleteVehicle(id);
        return ResponseEntity.ok("successfully deleted");
    }

    /**
     *
     * @param type take type -> highest or Cheapest
     * @return VehicleDTO as response
     */
    @GetMapping("/sort-price/{type}")
    public  ResponseEntity<VehicleDTO> sortVehiclePrice(@PathVariable String type) {
        Vehicle vehicle = factoryService.sortPrice(type);
        VehicleDTO vehicleDTO = VehicleDTOMapper.vehicleToDTO(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

}
