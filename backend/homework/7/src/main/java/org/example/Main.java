package org.example;


import org.example.config.AppConfig;
import org.example.data.InventoryStore;
import org.example.util.LogBack;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InventoryStore inventoryStore = context.getBean(InventoryStore.class);
        LogBack.infoLogger("Vehicle with highest Price:");
        LogBack.infoLogger(inventoryStore.getHighestPriceVehicle().toString());
        LogBack.infoLogger("Vehicle with Lowest Price:");
        LogBack.infoLogger(inventoryStore.getLowestPriceVehicle().toString());




    }
}