package com.example.handson3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleDTO {
    private Long id;
    private String name;
    private double price;

}
