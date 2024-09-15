package com.example.assesment2.service;

import com.example.assesment2.dao.ProductRepository;
import com.example.assesment2.dto.ProductDTO;
import com.example.assesment2.entity.Product;
import com.example.assesment2.exception.custom.CustomException;
import com.example.assesment2.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;
    PersonService personService;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, PersonService personService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.personService = personService;
    }

    /**
     * can only be done by admin
     * @param productRequestDTO
     */
    public void addProduct(ProductDTO productRequestDTO){
        try{
        productRepository.save(productMapper.mapProductDTO(productRequestDTO));
    } catch (Exception e){
        throw new CustomException(e.getMessage());
    }
    }

    /**
     *get product by id
     * @param productid
     * @return
     */
    public ProductDTO getProductById(UUID productid){
        return  productMapper.mapProduct(productRepository.getReferenceById(productid));
    }

    /**
     * can only be done by admin
     * @param productRequestDTO
     * @param productid
     */
    public void updateProductById(ProductDTO productRequestDTO,UUID productid){
        try{
        Product updatedProduct = productMapper.mapProductDTO(productRequestDTO);
        productRepository.setProductInfoById(updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getPrice(), updatedProduct.getQuantity(), productid);
    } catch (Exception e){
        throw new CustomException(e.getMessage());
    }
    }

    /**
     * update while placing order
     * @param updatedQuantity
     * @param productid
     */
    public void updateProductQuantityById(int updatedQuantity,UUID productid){
        try{
        productRepository.setProductQuantityById(updatedQuantity,productid);
    } catch (Exception e){
        throw new CustomException(e.getMessage());
    }
    }

    /**
     * can only be done by admin
     * @param productid
     */
    public void deleteProductsById(UUID productid){
        try{
        productRepository.deleteById(productid);
    } catch (Exception e){
        throw new CustomException(e.getMessage());
    }
    }

}
