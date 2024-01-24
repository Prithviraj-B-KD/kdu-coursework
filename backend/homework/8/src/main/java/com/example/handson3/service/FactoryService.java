package com.example.handson3.service;

import com.example.handson3.dto.VehicleDTO;
import com.example.handson3.dto.VehicleDTOMapper;
import com.example.handson3.model.Vehicle;
import com.example.handson3.repositories.InventoryRepository;
import com.example.handson3.util.LogBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryService implements VehicleFactory{
    InventoryRepository inventory;

    @Autowired
    FactoryService(InventoryRepository inventoryRepository){
        this.inventory = inventoryRepository;
    }
    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleDTOMapper.DTOToVehicle(vehicleDTO);
        inventory.addVehicle(vehicle);
        LogBack.infoLogger("Added Vehicle");
    }

    @Override
    public Vehicle getVehicle(Long id) {
        Vehicle vehicle = inventory.getVehicleById(id);
        LogBack.infoLogger("Vehicle Found");
        return vehicle;
    }

    @Override
    public void updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleDTOMapper.DTOToVehicle(vehicleDTO);
        inventory.updateVehicleById(id,vehicle);
        LogBack.infoLogger("Updated Vehicle");

    }

    @Override
    public void deleteVehicle(Long id) {
        inventory.deleteVehicleByID(id);
        LogBack.infoLogger("Vehicle Deleted");
    }
}
