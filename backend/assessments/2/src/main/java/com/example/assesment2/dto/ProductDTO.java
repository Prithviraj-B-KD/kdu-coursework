package com.example.assesment2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String productname;
    private String description;
    private double price;
    private int quantity;
}
