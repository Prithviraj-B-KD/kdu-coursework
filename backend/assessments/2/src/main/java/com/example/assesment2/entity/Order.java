package com.example.assesment2.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Builder
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;
}
