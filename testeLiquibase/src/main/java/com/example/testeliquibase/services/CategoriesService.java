package com.example.testeliquibase.services;

import com.example.testeliquibase.dtos.CategoriesDto;
import com.example.testeliquibase.entities.Categories;
import com.example.testeliquibase.produtoInterface.CategoriesInterface;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriesService {
    private final CategoriesInterface repository;
    private final ModelMapper modelMapper;

    public CategoriesService(CategoriesInterface repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    private CategoriesDto toCategoriesDto(Categories categories) {
        return modelMapper.map(categories, CategoriesDto.class);
    }


    public ResponseEntity<Object> getAllCategories(PageRequest pageRequest) {
        Page<Object> page = repository.findAll(pageRequest).map(this::toCategoriesDto);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity<Object> postNewCategorie(CategoriesDto categoriesDto) {
        Categories categories = new Categories(categoriesDto);
        return ResponseEntity.ok(repository.save(categories));
    }

    public ResponseEntity<Object> deleteById(Long categorieId) {
        boolean exist = repository.existsById(categorieId);
        if (!exist) {
            throw new IllegalStateException("categoria com id " + categorieId + " não existe!");
        }
        repository.deleteById(categorieId);
        return ResponseEntity.status(HttpStatus.OK).body("categoria de id " + categorieId + " foi deletado!");
    }

    public ResponseEntity<Object> updateById(Long categorieId, CategoriesDto categoriesDto) {
        boolean exist = repository.existsById(categorieId);
        if (!exist) {
            throw new IllegalStateException("categoria com id " + categorieId + " não existe!");
        }
        Categories categories = repository.findById(categorieId)
                .orElseThrow(() -> new IllegalStateException("Jogador com id " + categorieId + " não existe!"));

            categories.setTipo(categoriesDto.getTipo());
        categories.setPopularidade(categoriesDto.getPopularidade());
return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
