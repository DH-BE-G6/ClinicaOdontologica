package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.EnderecoDTO;

public class ValidationEndereco {

    public String validationEnderecoVariables(EnderecoDTO enderecoDTO) {
        if (enderecoDTO.getLogradouro() == null) {
            return "Rua não preenchida";
        } else if (enderecoDTO.getNumero() == null) {
            return "Número não preenchido";
        } else if (enderecoDTO.getComplemento() == null) {
            return "Complemento não preenchido";
        } else if (enderecoDTO.getBairro() == null) {
            return "Bairro não preenchido";
        } else if (enderecoDTO.getCidade() == null) {
            return "Cidade não preenchida";
        } else if (enderecoDTO.getEstado() == null) {
            return "Estado não preenchido";
        } else if (enderecoDTO.getCep() == null) {
            return "CEP não preenchido";
        }
        return null;
    }
}
