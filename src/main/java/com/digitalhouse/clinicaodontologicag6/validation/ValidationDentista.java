package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;

public class ValidationDentista {

    public String validationDentistaVariables(DentistaDTO dentistaDTO) {
        if (dentistaDTO.getNome() == null) {
            return "Nome não preenchido";
        } else if (dentistaDTO.getSobrenome() == null) {
            return "Sobrenome não preenchido";
        } else if (dentistaDTO.getMatricula() == null) {
            return "Matrícula não preenchida";
        }
        return null;
    }
}
