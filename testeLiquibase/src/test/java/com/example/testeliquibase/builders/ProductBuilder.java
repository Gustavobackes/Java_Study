package com.example.testeliquibase.builders;

import com.example.testeliquibase.dtos.CategoriesDto;
import com.example.testeliquibase.dtos.ProductsDto;
import com.example.testeliquibase.entities.Categories;
import com.example.testeliquibase.entities.Products;


import java.util.List;
import java.util.Optional;


public class ProductBuilder {
    public Products products;
    public ProductsDto productsDto;
    public Optional<Products> productsOptional;

    private final long ID = 1;
    private final String NOME = "Gustavo";
    private final Double VALOR = 30.32;
    private List<Categories> CATEGORIES;

    private List<CategoriesDto> CATEGORIESDTO;

    public void buildProduct() {
        products = new Products(ID, NOME, VALOR, CATEGORIES);
        productsDto = new ProductsDto(ID, NOME, VALOR, CATEGORIESDTO);
        productsOptional = Optional.of(new Products(ID, NOME, VALOR, CATEGORIES));
    }
}
