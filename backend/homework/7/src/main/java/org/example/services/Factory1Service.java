package org.example.services;

import jakarta.annotation.PostConstruct;
import org.example.data.InventoryStore;
import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("factory1")
public class Factory1Service extends VehicleFactoryService{


    @Autowired
    private SpeakerService speakerService;

    private TyreService tyreService;
    @Autowired
    public Factory1Service(@Qualifier("central")InventoryStore inventoryStore){
        this.inventory = inventoryStore;
    }
    @Autowired
    public void setTyreService(TyreService tyreService){
        this.tyreService=tyreService;
    }


    public String getFactoryId() {
        return "Factory1"; // Assign a unique ID for this factory
    }

    /**
     *
     * @return price of the vehicle after adding speaker and tyre and base price of vehicle
     */
    @Override
    public double calculatePrice() {
        return speakerService.sonyPrice + tyreService.mrfPrice + basePrice*1.1;
    }

    /**
     * add the created  vehicle object to inventory central
     */
    @PostConstruct
    @Override
    public void createVehicle() {

        inventory.addVehicles(new Vehicle(tyreService.mrf(),speakerService.sony(),calculatePrice(),getFactoryId()));
    }
}
