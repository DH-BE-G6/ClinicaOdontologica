package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.ConsultaEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDTO {
    private Integer id;
    private Integer idDentista;
    private Integer idPaciente;
    private LocalDateTime dataHoraConsulta;

    public ConsultaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}
