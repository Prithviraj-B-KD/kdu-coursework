package com.example.assesment2.service;

import com.example.assesment2.dao.OrderRepository;
import com.example.assesment2.dto.OrderDTO;
import com.example.assesment2.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository,OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderDTO orderDTO){
        orderRepository.save(orderMapper.mapOrderDTO(orderDTO));
    }

    public void delteOrder(UUID orderid){
        orderRepository.deleteById(orderid);
    }
}
