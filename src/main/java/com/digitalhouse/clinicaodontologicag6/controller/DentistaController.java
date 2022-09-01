package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.DentistaServiceImpl;
import com.digitalhouse.clinicaodontologicag6.validation.ValidationDentista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    private ValidationDentista validationDentista = new ValidationDentista();

    @PostMapping
    public ResponseEntity<DentistaDTO> create(@RequestBody DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity = null;
        String erro = validationDentista.validationDentistaVariables(dentistaDTO);
        if (erro == null) {
            DentistaDTO dentistaDTO1 = dentistaService.create(dentistaDTO);
            responseEntity = new ResponseEntity<>(dentistaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public DentistaDTO getById(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getById(id);
        if (dentistaDTO != null) {
            responseEntity = new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return dentistaService.getById(id);
    }

    @GetMapping("/getAll")
    public List<DentistaDTO> getAll() {
        return dentistaService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return dentistaService.delete(id);
    }

    @PutMapping("/{id}")
    public DentistaDTO update(@RequestBody DentistaDTO dentistaDTO, @PathVariable int id) {
        return dentistaService.update(dentistaDTO, id);
    }

    @GetMapping("/getByNome")
    public DentistaDTO getByNome(@RequestParam(value = "nome") String nome) {
        return dentistaService.getByNome(nome);
    }
}
