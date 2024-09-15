package com.example.assesment2.dao;

import com.example.assesment2.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Modifying
    @Transactional
    @Query("update Product p set p.name = ?1, p.description = ?2 ,p.price = ?3 ,p.quantity =?4 where p.id = ?5")
    void setProductInfoById(String name, String description,Double price,Integer quantity, UUID productId);

    @Modifying
    @Transactional
    @Query("update Product p set p.quantity =?1 where p.id =?2")
    void setProductQuantityById(Integer updatedQuantity,UUID productid);
}
