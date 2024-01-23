package org.example.services;

import jakarta.annotation.PostConstruct;
import org.example.data.InventoryStore;
import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("factory2")
public class Factory2Service extends VehicleFactoryService{
    @Autowired
    private SpeakerService speakerService;

    private TyreService tyreService;

    @Autowired
    public void setTyreService(TyreService tyreService){
        this.tyreService=tyreService;
    }


    @Autowired
    public Factory2Service(InventoryStore inventoryStore) {
        this.inventory = inventoryStore;
    }

    public String getFactoryId() {
        return "Factory2"; // Assign a unique ID for this factory
    }

    /**
     *
     * @return price of the vehicle after adding speaker and tyre and base price of vehicle
     */
    @Override
    public double calculatePrice() {
       return tyreService.bridgeStonePrice + speakerService.bosePrice+ basePrice;
    }

    @PostConstruct
    @Override
    /**
     * add the created  vehicle object to inventory central
     */
    public void createVehicle() {
        // Construct the vehicle with necessary details
        // Set the factory ID for tracking
        inventory.addVehicles(new Vehicle(tyreService.bridgeStone(),speakerService.bose(),calculatePrice(),getFactoryId()));
    }
}
