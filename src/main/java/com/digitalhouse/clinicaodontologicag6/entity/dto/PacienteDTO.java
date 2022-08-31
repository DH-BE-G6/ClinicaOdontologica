package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {
    private int id;
    private String nome;
    private String sobrenome;
    private String matricula;

    public PacienteDTO(int id, String nome, String sobrenome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }


}
