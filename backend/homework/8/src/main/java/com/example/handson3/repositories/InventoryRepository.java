package com.example.handson3.repositories;

import com.example.handson3.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InventoryRepository {
    private Map<Long, Vehicle> vehicles = new HashMap<>();

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getId(),vehicle);
    }

    public Vehicle getVehicleById(Long id){
        return vehicles.get(id);
    }

    public void updateVehicleById(Long id,Vehicle vehicle){
        vehicles.put(id,vehicle);
    }

    public void deleteVehicleByID(Long id){
        vehicles.remove(id);
    }
}
