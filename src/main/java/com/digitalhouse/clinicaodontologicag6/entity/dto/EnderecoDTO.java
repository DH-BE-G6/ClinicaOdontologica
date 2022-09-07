<<<<<<< HEAD
package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoEntity;

public class EnderecoDTO {

    private Integer id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String pais;
    private String CEP;

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.id = enderecoEntity.getId();
        this.rua = enderecoEntity.getRua();
        this.numero = enderecoEntity.getNumero();
        this.cidade = enderecoEntity.getCidade();
        this.estado = enderecoEntity.getEstado();
        this.pais = enderecoEntity.getPais();
        this.CEP = enderecoEntity.getCEP();
    }

    public EnderecoDTO() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
=======
package com.digitalhouse.clinicaodontologicag6.entity.dto;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoEntity;

public class EnderecoDTO {

    private int id;

    private String logradouro, numero, complemento, bairro, cidade, estado, cep;

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.id = enderecoEntity.getId();
        this.logradouro = enderecoEntity.getLogradouro();
        this.numero = enderecoEntity.getNumero();
        this.complemento = enderecoEntity.getComplemento();
        this.bairro = enderecoEntity.getBairro();
        this.cidade = enderecoEntity.getCidade();
        this.estado = enderecoEntity.getEstado();
        this.cep = enderecoEntity.getCep();
    }

    public EnderecoDTO() {}

    public int getId() {
        return id;
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
>>>>>>> 42559ef2c0df1b55cd9d77d71677354365cda722
