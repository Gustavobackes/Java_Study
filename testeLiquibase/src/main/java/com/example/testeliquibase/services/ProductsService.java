package com.example.testeliquibase.services;

import com.example.testeliquibase.dtos.ProductsDto;
import com.example.testeliquibase.entities.Products;
import com.example.testeliquibase.produtoInterface.ProductsInterface;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsInterface productsInterface;
    private final ModelMapper modelMapper;

    public ProductsService(ProductsInterface productsInterface, ModelMapper modelMapper) {
        this.productsInterface = productsInterface;
        this.modelMapper = modelMapper;
    }

    //conversation of Entity to a Dto
    private ProductsDto toProductDto(Products products){
        return modelMapper.map(products, ProductsDto.class);
    }

    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> page = productsInterface.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    public Products postNewProduct(ProductsDto productsDto){
        Products products = new Products(productsDto);
        return productsInterface.save(products);
    }


}
