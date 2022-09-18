package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.DentistaServiceImpl;
import com.digitalhouse.clinicaodontologicag6.validation.ValidationDentista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    private final ValidationDentista validationDentista = new ValidationDentista();

    @PostMapping("/cadastrar")
    public ResponseEntity<DentistaDTO> create(@RequestBody DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity = null;
        String erro = validationDentista.validateDentistaVariables(dentistaDTO);
        if (erro == null) {
            try {
                DentistaDTO dentistaDTO1 = dentistaService.create(dentistaDTO);
                responseEntity = new ResponseEntity<>(dentistaDTO1, HttpStatus.CREATED);
            } catch (Exception e) {
                responseEntity = new ResponseEntity<>("A matrícula informada já encontra-se cadastrada!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            responseEntity = new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "id", method = RequestMethod.GET)
    public ResponseEntity<DentistaDTO> getById(@RequestParam int id) {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getById(id);
        if (dentistaDTO != null) {
            responseEntity = new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "nome", method = RequestMethod.GET)
    public ResponseEntity<List<DentistaDTO>> getByNome(@RequestParam String nome) {
        ResponseEntity responseEntity = null;
        List<DentistaDTO> dentistaDTO = dentistaService.getByNome(nome);
        if (dentistaDTO != null) {
            responseEntity = new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Nome não encontrado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "matricula", method = RequestMethod.GET)
    public ResponseEntity<DentistaDTO> getByMatricula(@RequestParam String matricula) {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getByMatricula(matricula);
        if (dentistaDTO != null) {
            responseEntity = new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Matricula não encontrada", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<DentistaDTO>> getAll() {
        ResponseEntity responseEntity = null;
        List<DentistaDTO> dentistaDTOList = dentistaService.getAll();
        if (dentistaDTOList != null) {
            responseEntity = new ResponseEntity<>(dentistaDTOList, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Nenhum dentista encontrado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "atualizar", params = "id", method = RequestMethod.PUT)
    public ResponseEntity<DentistaDTO> update(@RequestBody DentistaDTO dentistaDTO, @RequestParam int id) {
        ResponseEntity responseEntity = null;
        try {
            DentistaDTO dentistaDTO1 = dentistaService.update(dentistaDTO, id);
            responseEntity = new ResponseEntity<>(dentistaDTO1, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<String> delete(@RequestParam int id) {
        ResponseEntity responseEntity = null;
        try {
            dentistaService.delete(id);
            responseEntity = new ResponseEntity<>("Dentista excluído com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Dentista não encontrado!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
