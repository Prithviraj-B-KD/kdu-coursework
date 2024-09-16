package com.example.assesment2.controller;

import com.example.assesment2.dto.ProductDTO;
import com.example.assesment2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/admin")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
        return new ResponseEntity<>("Product added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/product/{productid}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable UUID productid){
        ProductDTO productResponseDTO= productService.getProductById(productid);
        return new ResponseEntity<>(productResponseDTO,HttpStatus.FOUND);
    }

    @PutMapping("/product/{productid}")
    public ResponseEntity<String> updateProductById(@PathVariable UUID productid , @RequestBody ProductDTO productDTO){
        productService.updateProductById(productDTO,productid);
        return new ResponseEntity<>("Successfully Updated Product",HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{productid}")
    public ResponseEntity<String> deleteProductById(@PathVariable UUID productid){
        productService.deleteProductsById(productid);
        return new ResponseEntity<>("Deleted Product Successfully",HttpStatus.ACCEPTED);
    }
}
