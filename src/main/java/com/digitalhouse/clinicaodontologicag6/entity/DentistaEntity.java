package com.digitalhouse.clinicaodontologicag6.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "Dentistas")
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "nome", nullable = false)
    @NotNull
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(unique = true, nullable = false)
    @NotNull
    private String matricula;

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
