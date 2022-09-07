package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;

public class ValidationPaciente {

    public String validationPacienteVariables(PacienteDTO pacienteDTO) {
        if (pacienteDTO.getNome() == null) {
            return "Nome não preenchido";
        } else if (pacienteDTO.getSobrenome() == null) {
            return "Sobrenome não preenchido";
        } else if (pacienteDTO.getEndereco() == null) {
            return "Endereço não preenchido";
        } else if (pacienteDTO.getRg() == null) {
            return "RG não preenchido";
        }
        return null;
    }
}
