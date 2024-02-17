package com.example.handson3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    private long id;
    private String name;
    private double price;
}
