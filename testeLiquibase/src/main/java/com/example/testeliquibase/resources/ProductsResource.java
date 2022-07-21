package com.example.testeliquibase.resources;

import com.example.testeliquibase.dtos.ProductsDto;
import com.example.testeliquibase.services.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("{productId}")
    public ResponseEntity<Object> getProductsById(@PathVariable("productId") Long productId){
        return service.getProductById(productId);
    }


    @PostMapping("/post")
    public ResponseEntity<Object> NewProduct(@RequestBody ProductsDto productsDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.postNewProduct(productsDto));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Object> deleteProductById(@PathVariable("productId")Long productId){
        return service.deleteProduct(productId);
    }
}
