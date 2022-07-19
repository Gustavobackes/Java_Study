package com.example.projetojpa.services;

import com.example.projetojpa.dtos.JogadorDto;
import com.example.projetojpa.dtos.JogadorDto2;
import com.example.projetojpa.entities.Jogador;
import com.example.projetojpa.repositories.Repository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
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

    private JogadorDto2 toJogadorDto2(Jogador jogador) {
        return modelMapper.map(jogador, JogadorDto2.class);
    }

    public Page<JogadorDto> findAll(PageRequest pageRequest) {
        Page<Jogador> jogador = repository.findAll(pageRequest);
        return jogador.map(JogadorDto::new);
    }

    public Optional<JogadorDto2> getJogador(Long jogadorId) {
        boolean exists = repository.existsById(jogadorId);
        if (!exists) {
            throw new IllegalStateException("Jogador com id " + jogadorId + " não existe!");
        }
        Optional<JogadorDto2> jogadorDto2 = repository.findById(jogadorId).map(this::toJogadorDto2);
        return jogadorDto2;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void deleteJogador(Long JogadorId) {
        boolean exists = repository.existsById(JogadorId);
        if (!exists) {
            throw new IllegalStateException("Jogador com id " + JogadorId + "does not exists!");
        }
        repository.deleteById(JogadorId);
    }

    public Jogador newJogador(JogadorDto2 jogadorDto2) {
        Optional<JogadorDto2> jogadorByEmail = repository.findJogadorByEmail(jogadorDto2.getEmail()).map(this::toJogadorDto2);
        if (jogadorByEmail.isPresent()) {
            throw new IllegalStateException("This e-mail is already taken!");
        }
        Jogador jogador = new Jogador(jogadorDto2);
        return repository.save(jogador);
    }

    public Object updateJogador(Long jogadorId, @Valid JogadorDto2 jogadorDto2) {
        Jogador jogador = repository.findById(jogadorId)
                .orElseThrow(() -> new IllegalStateException("Jogador com id " + jogadorId + " não existe!"));
        Optional<JogadorDto2> jogadorByEmail = repository.findJogadorByEmail(jogadorDto2.getEmail()).map(this::toJogadorDto2);
        if (jogadorByEmail.isPresent()) {
            throw new IllegalStateException("This e-mail is already taken!");
        }
        jogador.setEmail(jogadorDto2.getEmail());
        jogador.setName(jogadorDto2.getName());
        jogador.setScore(jogadorDto2.getScore());
        repository.save(jogador);
        return toJogadorDto2(jogador);
    }
}
