package com.example.testeliquibase.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String primeiroNome;
    String segundoNome;
    int senha;

    public Pessoa(PessoaDto pessoaDto) {
        primeiroNome = pessoaDto.getPrimeiroNome();
        segundoNome = pessoaDto.getSegundoNome();
    }
}
