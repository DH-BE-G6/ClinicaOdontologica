package com.digitalhouse.clinicaodontologicag6.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Consultas")
@Getter
@Setter
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "dentista", nullable = false)
    @NotNull
    private Integer dentista;

    @Column(name = "paciente", nullable = false)
    @NotNull
    private Integer paciente;

    @Column(name = "dataConsulta", nullable = false)
    @NotNull
    private String dataConsulta;

    @Column(name = "isConsultaFinished", nullable = false)
    @NotNull
    private boolean isConsultaFinished;

}
