package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;

public class PacienteDTO {

    private int id;
    private String nome, sobrenome;
    private String rg;
    private String dataAlta;
//    private EnderecoDTO endereco;

    public PacienteDTO(PacienteEntity pacienteEntity) {
        this.id = pacienteEntity.getId();
        this.nome = pacienteEntity.getNome();
        this.sobrenome = pacienteEntity.getSobrenome();
        this.rg = pacienteEntity.getRg();
        this.dataAlta = pacienteEntity.getDataAlta();
    }

    public PacienteDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

}
