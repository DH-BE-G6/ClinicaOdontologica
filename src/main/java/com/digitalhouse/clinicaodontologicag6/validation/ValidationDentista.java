package com.digitalhouse.clinicaodontologicag6.validation;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;

public class ValidationDentista {

    public String validateDentistaVariables(DentistaDTO dentistaDTO) {
        if (dentistaDTO.getNome() == null ||
            dentistaDTO.getSobrenome() == null ||
            dentistaDTO.getMatricula() == null) {
            return "Todos os campos para o cadastro de dentistas devem ser informados.";
        }
        return null;
    }

}
