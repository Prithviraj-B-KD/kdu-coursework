package com.example.handson3.service;

import com.example.handson3.dto.VehicleDTO;
import com.example.handson3.model.Vehicle;

public interface VehicleFactory {
    public void addVehicle(VehicleDTO vehicleDTO);
    public Vehicle getVehicle(Long id);
    public void updateVehicle(Long id,VehicleDTO vehicleDTO);
    public void deleteVehicle(Long id);




}
