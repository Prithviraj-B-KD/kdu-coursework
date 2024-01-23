package org.example.data;

import org.example.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("central")
public class InventoryStore {
    private Map<String, List<Vehicle>> inventory = new HashMap<>();

    /**
     * adds the vehicle to their respective factory list
     * @param vehicle from the factoryservice class
     */
    public void addVehicles(Vehicle vehicle){
        inventory.computeIfAbsent(vehicle.getFactoryId(),k-> new ArrayList<>()).add(vehicle);
    }

    public List<Vehicle> getVehicles(String factoryID){
        return inventory.get(factoryID);
    }

    /**
     *
     * @return most expensive vehicle manufactured out of the two factories
     */
    public Vehicle getHighestPriceVehicle() {
        return inventory.values().stream().flatMap(List::stream).max(Comparator.comparing(Vehicle::getPrice)).orElse(null);
    }

    /**
     *
     * @return cheapest vehicle manufactured out of the two factories
     */
    public Vehicle getLowestPriceVehicle(){
        return inventory.values().stream().flatMap(List::stream).min(Comparator.comparing(Vehicle::getPrice)).orElse(null);
    }
}
