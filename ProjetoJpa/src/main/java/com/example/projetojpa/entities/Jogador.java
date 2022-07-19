package com.example.projetojpa.entities;

import com.example.projetojpa.dtos.JogadorDto;
import com.example.projetojpa.dtos.JogadorDto2;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Jogadores")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Double score;


    public Jogador(JogadorDto2 jogadorDto2) {
        name = jogadorDto2.getName();
        email = jogadorDto2.getEmail();
        score = jogadorDto2.getScore();
    }

    public Jogador(JogadorDto jogadorDto) {
        name = jogadorDto.getName();
        score = jogadorDto.getScore();
    }
}
