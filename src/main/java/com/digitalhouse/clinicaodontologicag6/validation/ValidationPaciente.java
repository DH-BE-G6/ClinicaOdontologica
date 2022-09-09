package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;

public class ValidationPaciente {

    public String validationPacienteVariables(PacienteDTO pacienteDTO) {
        if (pacienteDTO.getNome() == null) {
            return "Nome não preenchido";
        } else if (pacienteDTO.getSobrenome() == null) {
            return "Sobrenome não preenchido";
        } else if (pacienteDTO.getRg() == null) {
            return "RG não preenchido";
        } else if (pacienteDTO.getLogradouro() == null) {
            return "Logradouro não preenchido";
        } else if (pacienteDTO.getNumero() == null) {
            return "Número não preenchido";
        } else if (pacienteDTO.getBairro() == null) {
            return "Bairro não preenchido";
        } else if (pacienteDTO.getCidade() == null) {
            return "Cidade não preenchida";
        } else if (pacienteDTO.getEstado() == null) {
            return "Estado não preenchido";
        } else if (pacienteDTO.getCep() == null) {
            return "CEP não preenchido";
        }
        return null;
    }
}
