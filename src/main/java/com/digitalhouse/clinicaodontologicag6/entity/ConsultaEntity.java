package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.compositeKey.ConsultaEntityKey;
import com.digitalhouse.clinicaodontologicag6.entity.dto.ConsultaDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
public class ConsultaEntity {

    @EmbeddedId
    ConsultaEntityKey id;

    @ManyToOne
    @MapsId("pacienteId")
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @ManyToOne
    @MapsId("dentistaId")
    @JoinColumn(name = "dentista_id")
    private DentistaEntity dentista;

    @Column(name = "dataHoraConsulta", updatable = true, nullable = false, unique = true)
    private LocalDateTime dataHoraConsulta;

    public ConsultaEntity() {
    }

    public ConsultaEntityKey getId() {
        return id;
    }

    public void setId(ConsultaEntityKey id) {
        this.id = id;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public DentistaEntity getDentista() {
        return dentista;
    }

    public void setDentista(DentistaEntity dentista) {
        this.dentista = dentista;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}
