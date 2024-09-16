package com.example.assesment2.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

   @Column(name = "userid")
   @JsonDeserialize
    private UUID userid;

   @Column(name = "total")
    private double total;

   @ManyToOne(fetch = FetchType.LAZY)
   private Product product;
}
