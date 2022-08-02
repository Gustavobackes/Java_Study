package com.example.projetojpa.repositories;

import com.example.projetojpa.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Repository extends JpaRepository<Jogador, Long> {
    Optional<Jogador> findJogadorByEmail(String email);
}