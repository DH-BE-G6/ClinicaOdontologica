package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DentistaDTO {

    private int id;
    private String nome;
    private String sobrenome;
    private String matricula;

    public DentistaDTO(DentistaEntity dentistaEntity) {
        this.id = dentistaEntity.getId();
        this.nome = dentistaEntity.getNome();
        this.sobrenome = dentistaEntity.getSobrenome();
        this.matricula = dentistaEntity.getMatricula();
    }

}
