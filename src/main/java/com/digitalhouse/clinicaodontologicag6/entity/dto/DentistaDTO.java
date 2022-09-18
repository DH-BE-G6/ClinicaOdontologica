package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DentistaDTO {

    private Long id;
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
