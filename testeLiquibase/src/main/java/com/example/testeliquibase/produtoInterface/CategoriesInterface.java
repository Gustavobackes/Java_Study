package com.example.testeliquibase.produtoInterface;

import com.example.testeliquibase.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesInterface extends JpaRepository<Categories, Long> {
}
