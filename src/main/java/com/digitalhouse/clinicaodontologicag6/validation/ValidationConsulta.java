package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.ConsultaDTO;

public class ValidationConsulta {

    private String ValidateConsultaVariables(ConsultaDTO consultaDTO) {

        if (consultaDTO.getPaciente() == null ||
            consultaDTO.getDentista() == null ||
            consultaDTO.getDataConsulta() == null) {
            return "Todos os campos para o cadastro de consultas devem ser informados.";
        }
        return null;

    }
}
