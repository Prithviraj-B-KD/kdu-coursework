package com.example.assesment2.controller;

import com.example.assesment2.dto.ProductDTO;
import com.example.assesment2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UserProductController {
    ProductService productService;

    @Autowired
    public UserProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/product/{productid}")
    public ResponseEntity<String> updateProductById(@PathVariable UUID productid , @RequestBody int updatedQuantity){
        productService.updateProductQuantityById(updatedQuantity,productid);
        return new ResponseEntity<>("Successfully Updated Product", HttpStatus.CREATED);
    }
    @GetMapping("/product/{productid}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID productid){
        ProductDTO productResponseDTO= productService.getProductById(productid);
        return new ResponseEntity<>(productResponseDTO,HttpStatus.FOUND);
    }

}
