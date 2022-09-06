package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentista")
public class DentistaController {
    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public DentistaDTO create(@RequestBody DentistaDTO dentistaDTO) {
        return dentistaService.create(dentistaDTO);
    }

    @GetMapping("/{id}")
    public DentistaDTO getById(@PathVariable int id) {
        return dentistaService.getById(id);
    }
}
