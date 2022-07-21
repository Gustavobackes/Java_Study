package com.example.testeliquibase.services;

import com.example.testeliquibase.dtos.ProductsDto;
import com.example.testeliquibase.entities.Products;
import com.example.testeliquibase.produtoInterface.ProductsInterface;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsInterface repository;
    private final ModelMapper modelMapper;

    public ProductsService(ProductsInterface repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    //conversation of Entity to a Dto
    private ProductsDto toProductDto(Products products) {
        return modelMapper.map(products, ProductsDto.class);
    }


    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> page = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    public ResponseEntity<Object> getProductById(Long productId) {
        boolean exist = repository.existsById(productId);
        if (!exist) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com id " + productId + " não existe!");
        }
        Optional<ProductsDto> productsDto = repository.findById(productId).map(this::toProductDto);
        return ResponseEntity.status(HttpStatus.OK).body(productsDto);
    }

    @Transactional
    public Products postNewProduct(ProductsDto productsDto) {
        Products products = new Products(productsDto);
        return repository.save(products);
    }

    public ResponseEntity<Object> deleteProduct(Long productId){
        boolean exist = repository.existsById(productId);
        if (!exist) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com id " + productId + " não existe!");
        }
        repository.deleteById(productId);
        return ResponseEntity.status(HttpStatus.OK).body("Produto com id " + productId + " foi excluido!");
    }


}
