package com.example.handson3.dto;

import com.example.handson3.model.Vehicle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleDTOMapper {

    private VehicleDTOMapper (){
        log.error("Mapper class cant be instantiated");
    }

    /**
     *
     * @param vehicle vehicle object passed from service
     * @return vehicleDTO
     */
    public static VehicleDTO vehicleToDTO(Vehicle vehicle){
        return new VehicleDTO.VehicleDTOBuilder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .price(vehicle.getPrice())
                .build();
    }

    /**
     *
     * @param vehicleDTO vehicle DTO passed from api
     * @return vehicle
     */
    public static Vehicle dTOToVehicle(VehicleDTO vehicleDTO){
         return Vehicle.builder().id(vehicleDTO.getId())
                 .name(vehicleDTO.getName())
                 .price(vehicleDTO.getPrice())
                 .build();
    }
}
