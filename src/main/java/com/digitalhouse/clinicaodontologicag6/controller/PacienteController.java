package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.PacienteServiceImpl;
import com.digitalhouse.clinicaodontologicag6.validation.ValidationPaciente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    private ValidationPaciente validationPaciente = new ValidationPaciente();

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;
        String erro = validationPaciente.validationPacienteVariables(pacienteDTO);
        if (erro == null) {
            PacienteDTO pacienteDTO1 = pacienteService.create(pacienteDTO);
            responseEntity = new ResponseEntity<>(pacienteDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public PacienteDTO getById(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteDTO = pacienteService.getById(id);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return pacienteService.getById(id);
    }

    @GetMapping("/getAll")
    public List<PacienteDTO> getAll() {
        return pacienteService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return pacienteService.delete(id);
    }

    @PutMapping("/{id}")
    public PacienteDTO update(@RequestBody PacienteDTO pacienteDTO, @PathVariable int id) {
        return pacienteService.update(pacienteDTO, id);
    }

    @GetMapping("/getByNome")
    public PacienteDTO getByNome(@RequestParam(value = "nome") String nome) {
        return pacienteService.getByNome(nome);
    }
}
