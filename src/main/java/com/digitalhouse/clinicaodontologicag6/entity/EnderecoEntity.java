package com.digitalhouse.clinicaodontologicag6.entity;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoDTO;
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
    private String rua, numero, complemento, bairro, cidade, estado, cep;

    @OneToOne(mappedBy = "endereco")
    private PacienteEntity paciente;

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getNumero();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
        this.cep = enderecoDTO.getCep();
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