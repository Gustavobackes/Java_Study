package com.example.projetojpa.repositories;

import com.example.projetojpa.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Jogador, Long> {

}