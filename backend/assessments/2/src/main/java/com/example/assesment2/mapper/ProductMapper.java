package com.example.assesment2.mapper;

import com.example.assesment2.dto.ProductDTO;
import com.example.assesment2.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapProductDTO(ProductDTO productDTO){
        return Product.builder()
                .name(productDTO.getProductname())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
    }

    public ProductDTO mapProduct(Product product)
    {
        return ProductDTO.builder()
                .productname(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }
}
