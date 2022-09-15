package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.ConsultaEntity;

import java.util.Set;

public class DentistaDTO {

    private int id;
    private String nome, sobrenome, matricula;

    private Set<ConsultaEntity> consultas;

    public DentistaDTO() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<ConsultaEntity> consultas) {
        this.consultas = consultas;
    }
}
