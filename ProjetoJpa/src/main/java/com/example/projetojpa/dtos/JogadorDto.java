package com.example.projetojpa.dtos;

import com.example.projetojpa.entities.Jogador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDto {
    private Long id;
    private String name;
    private Double score;

    public JogadorDto(Jogador jogador){
        this.id = jogador.getId();
        this.name = jogador.getName();
        this.score = jogador.getScore();
    }

}
