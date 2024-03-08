package org.example.services;

import jakarta.annotation.PostConstruct;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Component
public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    @Autowired
    private TyreService tyreService;

    @Autowired
    private SpeakerService speakerService;


    @PostConstruct
    public void generateVehicles() {
        for (int i = 0; i < 5; i++) {
            vehicles.add(new Vehicle(tyreService.mrf(), speakerService.sony(),
                    Math.random() * 10000)); // Generate random price for vehicle body
        }

    }

    /**
     * this method is used to find the most expensive vehicle using stream
     * @return vehicle object of most expensive customization
     */
    public Vehicle findMostExpensiveVehicle(){
        return  vehicles.stream()
                .max(Comparator.comparing(Vehicle::getPrice))
                .orElse(null);
    }
}

