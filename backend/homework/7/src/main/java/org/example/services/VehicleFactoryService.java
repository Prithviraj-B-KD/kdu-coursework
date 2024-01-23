package org.example.services;

import org.example.data.InventoryStore;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public abstract class VehicleFactoryService {

     double basePrice=10000.0;
     InventoryStore inventory;

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public abstract double calculatePrice();
    public abstract void createVehicle();

}
