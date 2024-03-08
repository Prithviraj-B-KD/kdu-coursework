package org.example;

import org.example.config.AppConfig;
import org.example.services.VehicleService;
import org.example.util.LogBack;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        VehicleService vehicleService = context.getBean(VehicleService.class);
        vehicleService.generateVehicles();
        LogBack.infoLogger("Most expensive vehicle:");
       LogBack.infoLogger(vehicleService.findMostExpensiveVehicle().toString());
    }
}