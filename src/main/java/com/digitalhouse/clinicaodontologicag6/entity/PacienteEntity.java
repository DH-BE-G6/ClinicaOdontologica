package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "Pacientes")
@SecondaryTable(name = "Enderecos")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "nome", nullable = false)
    @NotNull
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "rg", unique = true, nullable = false)
    @NotNull
    private String rg;

    @Column(name = "dataAlta")
    private String dataAlta;

    @Column(table = "Enderecos", name = "logradouro", nullable = false)
    private String logradouro;

    @Column(table = "Enderecos", name = "numero", nullable = false)
    private String numero;

    @Column(table = "Enderecos", name = "complemento")
    private String complemento;

    @Column(table = "Enderecos", name = "bairro", nullable = false)
    private String bairro;

    @Column(table = "Enderecos", name = "cidade", nullable = false)
    private String cidade;

    @Column(table = "Enderecos", name = "estado", nullable = false)
    private String estado;

    @Column(table = "Enderecos", name = "cep", nullable = false)
    private String cep;

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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
