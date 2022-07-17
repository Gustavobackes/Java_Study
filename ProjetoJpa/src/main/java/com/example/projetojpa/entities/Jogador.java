package com.example.projetojpa.entities;

import com.example.projetojpa.dtos.JogadorDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_players")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Double score;

    public Jogador(JogadorDto jogadorDto) {
        this.id = jogadorDto.getId();
        this.name = jogadorDto.getName();
        this.email = jogadorDto.getEmail();
        this.score = jogadorDto.getScore();
    }
}
