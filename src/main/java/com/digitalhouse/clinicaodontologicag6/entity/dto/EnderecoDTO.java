package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoDTO;
import com.sun.istack.NotNull;

import javax.persistence.*;

public class EnderecoDTO {

    private int id;
   
    private String rua, numero, complemento, bairro, cidade, estado, cep;

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.id = enderecoEntity.getId();
        this.rua = enderecoEntity.getRua();
        this.numero = enderecoEntity.getNumero();
        this.complemento = enderecoEntity.getComplemento();
        this.bairro = enderecoEntity.getBairro();
        this.cidade = enderecoEntity.getCidade();
        this.estado = enderecoEntity.getEstado();
        this.cep = enderecoEntity.getCep();
    }

    public EnderecoDTO() {
    }

    public int getId() {
        return id;
    }

    //public void setId(int id) {this.id = id;}

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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