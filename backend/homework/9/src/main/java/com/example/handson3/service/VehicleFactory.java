package com.example.handson3.service;

import com.example.handson3.dto.VehicleDTO;
import com.example.handson3.model.Vehicle;
import org.apache.coyote.BadRequestException;

public interface VehicleFactory {
    public void addVehicle(VehicleDTO vehicleDTO) throws BadRequestException;
    public Vehicle getVehicle(Long id);
    public void updateVehicle(Long id,VehicleDTO vehicleDTO);
    public void deleteVehicle(Long id);
    public Vehicle sortPrice(String type);



}
