package com.example.projetojpa.services;

import com.example.projetojpa.dtos.JogadorDto;
import com.example.projetojpa.entities.Jogador;
import com.example.projetojpa.repositories.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadorService {
    private final Repository repository;
    private final ModelMapper modelMapper;

    public JogadorService(Repository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    //entity and DTO conversation
    private JogadorDto toJogadorDto(Jogador jogador) {
        return modelMapper.map(jogador, JogadorDto.class);
    }


    public Page<JogadorDto> findAll(PageRequest pageRequest) {
        Page<Jogador> jogador = repository.findAll(pageRequest);
        return jogador.map(JogadorDto::new);
    }

    public Optional<JogadorDto> getJogador(Long jogadorId) {
        boolean exists = repository.existsById(jogadorId);
        if (!exists) {
            throw new IllegalStateException("Jogador with id " + jogadorId + " does not exists!");
        }
        return repository.findById(jogadorId).map(this::toJogadorDto);
    }
}