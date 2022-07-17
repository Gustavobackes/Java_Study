package com.example.projetojpa.services;

import com.example.projetojpa.dtos.JogadorDto;
import com.example.projetojpa.entities.Jogador;
import com.example.projetojpa.repositories.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class JogadorService {
    private final Repository repository;
    private final ModelMapper modelMapper;

    public JogadorService(Repository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    // entity and DTO conversation
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
            throw new IllegalStateException("Jogador com id " + jogadorId + " não existe!");
        }
        return repository.findById(jogadorId).map(this::toJogadorDto);
    }

    @Transactional
    public void deleteJogador (Long JogadorId) {
        boolean exists = repository.existsById(JogadorId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + JogadorId + "does not exists!");
        }
        repository.deleteById(JogadorId);
    }

    public Jogador newJogador(JogadorDto jogadorDto){
        Optional<JogadorDto> jogadorByEmail = repository.findJogadorByEmail(jogadorDto.getEmail()).map(this::toJogadorDto);
        if (jogadorByEmail.isPresent()) {
            throw new IllegalStateException("This e-mail is already taken!");
        }
        Jogador studentEntity = new Jogador(jogadorDto);
        return repository.save(studentEntity);
    }
}
}