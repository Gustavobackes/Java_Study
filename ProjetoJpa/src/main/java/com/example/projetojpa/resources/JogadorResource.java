package com.example.projetojpa.resources;

import com.example.projetojpa.dtos.JogadorDto;
import com.example.projetojpa.services.JogadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorResource {

  private final JogadorService service;

    public JogadorResource(JogadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<JogadorDto>> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "8") Integer size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<JogadorDto> jogadorDto = service.findAll(pageRequest);
        return ResponseEntity.ok(jogadorDto);
    }

    @GetMapping("/{jogadorId}")
    public Optional<JogadorDto> getJogador(@PathVariable("jogadorId")Long jogadorId){
        return service.getJogador(jogadorId);
    }
}