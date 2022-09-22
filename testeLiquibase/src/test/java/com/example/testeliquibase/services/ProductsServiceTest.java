package com.example.testeliquibase.services;

import com.example.testeliquibase.builders.ProductBuilder;
import com.example.testeliquibase.dtos.CategoriesDto;
import com.example.testeliquibase.dtos.ProductsDto;
import com.example.testeliquibase.entities.Categories;
import com.example.testeliquibase.entities.Products;
import com.example.testeliquibase.produtoInterface.ProductsInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsServiceTest {

    @Mock
    private ProductBuilder productBuilder;
    private ProductsService service;
    @Mock
    private ProductsInterface repository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
        service = new ProductsService(repository, modelMapper);
        productBuilder.buildProduct();
    }

    @Test
    void deveRetornarListaCom10Elementos_retornarStatus200() {
        Products produto = new Products();
        List<Products> productsList = Collections.singletonList(produto);
        Page<Products> productsPage = new PageImpl<Products>(productsList);
        PageRequest pageRequest = PageRequest.of(0, 10);
        when(repository.findAll(pageRequest)).thenReturn(productsPage);
        ResponseEntity<Object> result = service.getAllProducts(pageRequest);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void deveRetornarProdutoComId_Status200() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(productBuilder.productsOptional);

        ResponseEntity<Object> result = service.getProductById(productBuilder.products.getId());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

//    @Test
//    void deveRetornarNotFound_QuandoIdNaoExiste() {
//        Long id;
//        Products products = new Products();
//        Optional<Products> productsOptional = Optional.of(products);
//        doReturn(false).when(rep);
//    }


}
