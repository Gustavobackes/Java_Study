package com.example.testeliquibase.produtoInterface;

import com.example.testeliquibase.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsInterface extends JpaRepository<Products, Long> {
}
