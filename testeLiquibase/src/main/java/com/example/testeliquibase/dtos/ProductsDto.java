package com.example.testeliquibase.dtos;

import com.example.testeliquibase.entities.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {
    private Long id;
    private String nome;
    private Double valor;

    private List<CategoriesDto> categoriesDtos;
    ProductsDto(Products products) {
        id = products.getId();
        nome = products.getNome();
        valor = products.getValor();
    }
}
