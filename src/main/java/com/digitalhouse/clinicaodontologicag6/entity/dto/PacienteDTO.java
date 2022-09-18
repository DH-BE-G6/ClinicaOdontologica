package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO {

    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private String dataAlta;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public PacienteDTO(PacienteEntity pacienteEntity) {
        this.id = pacienteEntity.getId();
        this.nome = pacienteEntity.getNome();
        this.sobrenome = pacienteEntity.getSobrenome();
        this.rg = pacienteEntity.getRg();
        this.dataAlta = pacienteEntity.getDataAlta();
        this.logradouro = pacienteEntity.getLogradouro();
        this.numero = pacienteEntity.getNumero();
        this.complemento = pacienteEntity.getComplemento();
        this.bairro = pacienteEntity.getBairro();
        this.cidade = pacienteEntity.getCidade();
        this.estado = pacienteEntity.getEstado();
        this.cep = pacienteEntity.getCep();
    }

}
