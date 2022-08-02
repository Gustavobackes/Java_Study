package com.example.projetojpa.dtos;

import com.example.projetojpa.entities.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDto2 {
    private Long id;
    private String name;
    private String email;
    private Double score;

    public JogadorDto2(Jogador jogador){
        this.id = jogador.getId();
        this.name = jogador.getName();
        this.email = jogador.getEmail();
        this.score = jogador.getScore();
    }

}