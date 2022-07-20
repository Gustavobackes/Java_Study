package com.example.testeliquibase.resources;

import com.example.testeliquibase.dtos.ProductsDto;
import com.example.testeliquibase.entities.Products;
import com.example.testeliquibase.services.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductsResource {

    private final ProductsService service;

    public ProductsResource(ProductsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @PostMapping("/post")
    public ResponseEntity<Object> NewProduct(@RequestBody ProductsDto productsDto) {
return ResponseEntity.status(HttpStatus.OK).body(service.postNewProduct(productsDto));
    }
}
