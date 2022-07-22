package com.example.testeliquibase.resources;

import com.example.testeliquibase.dtos.CategoriesDto;
import com.example.testeliquibase.services.CategoriesService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoriesResource {
    private final CategoriesService service;

    public CategoriesResource(CategoriesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCategories(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return service.getAllCategories(pageRequest);
    }

    @GetMapping("{categorieId}")
    public ResponseEntity<Object> getCategorieById(@PathVariable("categorieId")Long categorieId){
        return service.getCategorieById(categorieId);
    }

    @PostMapping("post")
    public ResponseEntity<Object> postNewCategorie(@RequestBody CategoriesDto categoriesDto){
        return service.postNewCategorie(categoriesDto);
    }
    @PutMapping("/put/{categorieId}")
    public ResponseEntity<Object> updateByid(@PathVariable("categorieId") Long categorieId, @RequestBody CategoriesDto categoriesDto){
        return service.updateById(categorieId, categoriesDto);
    }

    @DeleteMapping("/delete/{categorieId}")
    public ResponseEntity<Object> deleteById(@PathVariable("categorieId") Long caterioId){
        return service.deleteById(caterioId);
    }
}
