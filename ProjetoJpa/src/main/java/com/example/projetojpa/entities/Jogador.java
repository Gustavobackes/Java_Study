package com.example.projetojpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_players")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    Double score;



    public Jogador(Long id, String name, String email, Double score) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.score = score;
    }

   public Jogador(){
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
