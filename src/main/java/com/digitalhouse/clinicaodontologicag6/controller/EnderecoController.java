package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        return enderecoService.getById(id);
    }
}