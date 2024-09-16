package com.example.assesment2.dao;

import com.example.assesment2.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShoppinCartRepository extends JpaRepository<ShoppingCart, UUID> {
}
