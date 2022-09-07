<<<<<<< HEAD
package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Endereco")
public class EnderecoEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String pais;
    private String CEP;

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.CEP = CEP;
    }

    public EnderecoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
=======
package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.dto.EnderecoDTO;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "Enderecos")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull
    private String logradouro, numero, complemento, bairro, cidade, estado, cep;

    @OneToOne(mappedBy = "endereco")
    private PacienteEntity paciente;

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.logradouro = enderecoDTO.getLogradouro();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getNumero();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
        this.cep = enderecoDTO.getCep();
    }

    public EnderecoEntity() {}

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
