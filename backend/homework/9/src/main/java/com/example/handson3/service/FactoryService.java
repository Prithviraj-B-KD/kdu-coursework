package com.example.handson3.service;

import com.example.handson3.dto.VehicleDTO;
import com.example.handson3.dto.VehicleDTOMapper;
import com.example.handson3.exception.customExceptions.ResourceNotFoundException;
import com.example.handson3.model.Vehicle;
import com.example.handson3.repositories.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FactoryService implements VehicleFactory{
    InventoryRepository inventory;

    @Autowired
    FactoryService(InventoryRepository inventoryRepository){
        this.inventory = inventoryRepository;
    }
    @Override
    public void addVehicle(VehicleDTO vehicleDTO) throws BadRequestException {
        if(vehicleDTO.getId()==null ){
            throw new BadRequestException("Fill id field of the vehicle");
        } else if ( vehicleDTO.getName()==null) {
            throw new BadRequestException("give name of the vehicle");
        } else {
            Vehicle vehicle = VehicleDTOMapper.dTOToVehicle(vehicleDTO);
            inventory.addVehicle(vehicle);
            log.info("Added Vehicle");
        }
    }

    @Override
    public Vehicle getVehicle(Long id) {
        Vehicle vehicle = inventory.getVehicleById(id);
        if(vehicle==null){
            throw new ResourceNotFoundException("Couldn't find the vehicle with id:"+id+" in the inventory");
        }
        log.info("Vehicle Found");
        return vehicle;
    }

    /**
     *
     * @param id take vehicle id
     * @param vehicleDTO take vehicleDTO object and maps to get vehicle and adds the vehicle object to  inventory
     */
    @Override
    public void updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleDTOMapper.dTOToVehicle(vehicleDTO);
        inventory.updateVehicleById(id,vehicle);
        log.info("Updated Vehicle");

    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle =  inventory.deleteVehicleByID(id);
        if (vehicle == null){
            throw new ResourceNotFoundException("Vehicle with id:"+id+" doesn't exist");
        }else {
            log.info("Vehicle Deleted");
        }
    }

    /**
     *
     * @param type checks the type and calls the appropriate method to serve the request
     * @return vehicle
     */
    @Override
    public Vehicle sortPrice(String type) {
       if(type.equals("Highest")){
           return inventory.getHighestPriceVehicle();
       } else {
           return inventory.getCheapestPriceVehicle();
       }

    }

}
