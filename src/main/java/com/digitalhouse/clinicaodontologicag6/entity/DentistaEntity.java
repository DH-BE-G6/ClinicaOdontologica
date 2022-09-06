package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "Dentistas")
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NotNull
    private String nome, sobrenome;
    @Column(unique = true, nullable = false)
    @NotNull
    private String matricula;

    public DentistaEntity(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.matricula = dentistaDTO.getMatricula();
    }

    public DentistaEntity() {
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
}
