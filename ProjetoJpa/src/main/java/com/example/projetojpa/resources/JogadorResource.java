package com.example.projetojpa.resources;

import com.example.projetojpa.dtos.JogadorDto;
import com.example.projetojpa.dtos.JogadorDto2;
import com.example.projetojpa.services.JogadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
    public Optional<JogadorDto2> getJogador(@PathVariable("jogadorId")Long jogadorId){
        return service.getJogador(jogadorId);
    }

    @PostMapping("/post")
    public ResponseEntity<Object> registerNewJogador(@RequestBody JogadorDto2 jogadorDto2){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.newJogador(jogadorDto2));
    }

    @DeleteMapping("{jogadorId}")
    public ResponseEntity<Object> deleteJogador (@PathVariable("jogadorId") Long jogadorId){
        service.deleteJogador(jogadorId);
        return ResponseEntity.status(HttpStatus.OK).body("Jogador com ID" + jogadorId + "foi deletado!");
    }
    @PutMapping("/put/{jogadorId}")
    public ResponseEntity<Object> updateJogador (@PathVariable("jogadorId") Long jogadorId, @RequestBody JogadorDto2 jogadorDto2){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateJogador(jogadorId, jogadorDto2));
    }
}