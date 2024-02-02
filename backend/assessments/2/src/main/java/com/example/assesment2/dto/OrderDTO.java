package com.example.assesment2.dto;

import com.example.assesment2.entity.Address;
import com.example.assesment2.entity.Product;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDTO {
    private Timestamp orderDate;
    private Product product;
    private double totalAmount;
    private Address address;

}
