package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public PacienteDTO create(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.create(pacienteDTO);
    }

    @GetMapping("/{id}")
    public PacienteDTO getById(@PathVariable int id) {
        return pacienteService.getById(id);
    }
}
