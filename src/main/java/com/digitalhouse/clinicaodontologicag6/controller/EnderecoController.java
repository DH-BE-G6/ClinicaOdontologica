package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.EnderecoDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @PostMapping
    public EnderecoDTO create(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.create(enderecoDTO);
    }

    @GetMapping("/{id}")
    public EnderecoDTO getById(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        EnderecoDTO enderecoDTO = enderecoService.getById(id);
        if (enderecoDTO != null) {
            responseEntity = new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return enderecoService.getById(id);
    }
}
