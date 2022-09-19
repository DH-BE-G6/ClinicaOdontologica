package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.PacienteServiceImpl;
import com.digitalhouse.clinicaodontologicag6.validation.ValidationPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    private final ValidationPaciente validationPaciente = new ValidationPaciente();

    @PostMapping("/cadastrar")
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;
        String erro = validationPaciente.validatePacienteVariables(pacienteDTO);
        if (erro == null) {
            try {
                PacienteDTO pacienteDTO1 = pacienteService.create(pacienteDTO);
                responseEntity = new ResponseEntity<>(pacienteDTO1, HttpStatus.CREATED);
            } catch (Exception e) {
                responseEntity = new ResponseEntity<>("O RG informado já encontra-se cadastrado!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            responseEntity = new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "id", method = RequestMethod.GET)
    public ResponseEntity<PacienteDTO> getById(@RequestParam Long id) {
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteDTO = pacienteService.getById(id);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "nome", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> getByNome(@RequestParam String nome) {
        ResponseEntity responseEntity = null;
        List<PacienteDTO> pacienteDTO = pacienteService.getByNome(nome);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Nome não encontrado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "cidade", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> getByCidade(@RequestParam String cidade) {
        ResponseEntity responseEntity = null;
        List<PacienteDTO> pacienteDTO = pacienteService.getByCidade(cidade);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Cidade não encontrada", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscar", params = "rg", method = RequestMethod.GET)
    public ResponseEntity<PacienteDTO> getByRg(@RequestParam String rg) {
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteDTO = pacienteService.getByRg(rg);
        if (pacienteDTO != null) {
            responseEntity = new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("RG não encontrado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> getAll() {
        ResponseEntity responseEntity = null;
        List<PacienteDTO> pacienteDTOList = pacienteService.getAll();
        if (pacienteDTOList != null) {
            responseEntity = new ResponseEntity<>(pacienteDTOList, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Nenhum paciente encontrado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @RequestMapping(value = "atualizar", params = "id", method = RequestMethod.PUT)
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO, @RequestParam Long id) {
        ResponseEntity responseEntity = null;
        try {
            PacienteDTO pacienteDTO1 = pacienteService.update(pacienteDTO, id);
            responseEntity = new ResponseEntity<>(pacienteDTO1, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("ID não encontrada", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        ResponseEntity responseEntity = null;
        try {
            pacienteService.delete(id);
            responseEntity = new ResponseEntity<>("Paciente excluído com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Paciente não encontrado!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
