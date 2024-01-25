package com.example.handson3.repositories;

import com.example.handson3.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
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

    public Vehicle deleteVehicleByID(Long id){
       return vehicles.remove(id);
    }

    /**
     *
     * @return  the vehicle with highest price
     */
    public Vehicle getHighestPriceVehicle(){
        return vehicles.values().stream().max(Comparator.comparing(Vehicle::getPrice)).orElse(null);
    }

    /**
     *
     * @return the vehicle with cheapest price
     */
    public Vehicle getCheapestPriceVehicle(){
        return vehicles.values().stream().min(Comparator.comparing(Vehicle::getPrice)).orElse(null);
    }
}
