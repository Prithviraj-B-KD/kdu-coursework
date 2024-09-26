package com.example.handson3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleDTO {
    private Long id;
    private String name;
    private double price;

}
