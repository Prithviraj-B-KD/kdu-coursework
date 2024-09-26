package com.example.handson3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private long id;
    private String name;
    private double price;
}
