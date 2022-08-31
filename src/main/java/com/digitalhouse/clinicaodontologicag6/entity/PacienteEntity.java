package com.digitalhouse.clinicaodontologicag6.entity;

import java.util.Date;

public class PacienteEntity {

    private int id;
    private String nome;
    private String sobrenome;
    private String documentoIdentificacao;
    private String endereco;
    private Date dataAlta;

    public PacienteEntity(String nome, String sobrenome, String documentoIdentificacao, String endereco, Date dataAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documentoIdentificacao = documentoIdentificacao;
        this.endereco = endereco;
        this.dataAlta = dataAlta;
    }

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

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }
}
