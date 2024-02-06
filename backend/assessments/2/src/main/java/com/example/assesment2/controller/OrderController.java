package com.example.assesment2.controller;

import com.example.assesment2.dto.OrderDTO;
import com.example.assesment2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("order/add")
    public ResponseEntity<String> addOrder(OrderDTO orderDTO){
        orderService.placeOrder(orderDTO);
        return new ResponseEntity<>("AddedOrder successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("order/{orderid}")
    public ResponseEntity<String> deleteOrder(UUID orderid){
        orderService.delteOrder(orderid);
        return new ResponseEntity<>("Delete Order successfully", HttpStatus.CREATED);
    }
}
