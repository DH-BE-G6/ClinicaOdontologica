package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Pacientes")
public class PacienteEntity {

    //id int auto_increment primary key, nome varchar(255), sobrenome varchar(255), rg varchar(255), endereco int, dataAlta varchar(255);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NotNull
    private String nome, sobrenome;
    @Column(unique = true, nullable = false)
    @NotNull
    private String rg;
    @Column(nullable = false)
    @NotNull
    private String dataAlta;

    //@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    //@JoinColumn(name = "endereco_id")
    //private EnderecoEntity endereco;

    public int getId() {
        return id;
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

//    public EnderecoEntity getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(EnderecoEntity endereco) {
//        this.endereco = endereco;
//    }
}
