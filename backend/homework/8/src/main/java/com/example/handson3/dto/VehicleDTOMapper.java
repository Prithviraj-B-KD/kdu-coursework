package com.example.handson3.dto;


import com.example.handson3.model.Vehicle;

public class VehicleDTOMapper {

    /**
     *
     * @param vehicle
     * @return vehicleDTO
     */
    public static VehicleDTO vehicleToDTO(Vehicle vehicle ){
        return new VehicleDTO(vehicle.getId(), vehicle.getName(), vehicle.getPrice());
    }

    /**
     *
     * @param vehicleDTO
     * @return vehicle
     */
    public static Vehicle DTOToVehicle(VehicleDTO vehicleDTO){
        return new Vehicle(vehicleDTO.getId(),vehicleDTO.getName(),vehicleDTO.getPrice());
    }
}
