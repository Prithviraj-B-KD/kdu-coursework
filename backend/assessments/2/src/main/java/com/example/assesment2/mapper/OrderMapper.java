package com.example.assesment2.mapper;

import com.example.assesment2.dto.OrderDTO;
import com.example.assesment2.entity.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class OrderMapper {
    public Order mapOrderDTO(OrderDTO orderDTO){
        return Order.builder()
                .orderDate(Timestamp.valueOf(LocalDateTime.now()))
                .address(orderDTO.getAddress())
                .totalAmount(orderDTO.getTotalAmount())
                .product(orderDTO.getProduct())
                .build();
    }
}
