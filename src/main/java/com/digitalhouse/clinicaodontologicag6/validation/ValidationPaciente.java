package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;

public class ValidationPaciente {

    public String validatePacienteVariables(PacienteDTO pacienteDTO) {
        if (pacienteDTO.getNome() == null ||
                pacienteDTO.getSobrenome() == null ||
                pacienteDTO.getRg() == null ||
                pacienteDTO.getLogradouro() == null ||
                pacienteDTO.getNumero() == null ||
                pacienteDTO.getBairro() == null ||
                pacienteDTO.getCidade() == null ||
                pacienteDTO.getEstado() == null ||
                pacienteDTO.getCep() == null) {
            return "Todos os campos para o cadastro de pacientes devem ser informados.";
        }
        return null;
    }

}
