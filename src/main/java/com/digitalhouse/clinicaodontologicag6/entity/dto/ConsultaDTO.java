package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.ConsultaEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConsultaDTO {

    private int id;
    private Integer dentista;
    private Integer paciente;
    private String dataConsulta;
    private boolean isConsultaFinished;

    public ConsultaDTO(ConsultaEntity consultaEntity) {
        this.id = consultaEntity.getId();
        this.dentista = consultaEntity.getDentista();
        this.paciente = consultaEntity.getPaciente();
        this.dataConsulta = consultaEntity.getDataConsulta();
        this.isConsultaFinished = consultaEntity.isConsultaFinished();
    }

}
