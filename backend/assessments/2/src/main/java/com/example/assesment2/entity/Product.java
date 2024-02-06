package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "products")
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="description")
    private String description;
    @Column(name="quantity")
    private int quantity;

}
