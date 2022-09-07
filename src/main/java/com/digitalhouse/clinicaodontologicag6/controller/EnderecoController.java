<<<<<<< HEAD
package com.digitalhouse.clinicaodontologicag6.controller;

import com.digitalhouse.clinicaodontologicag6.entity.dto.EnderecoDTO;
import com.digitalhouse.clinicaodontologicag6.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired

    private EnderecoServiceImpl enderecoService;

    @PostMapping("/registrar")
    public ResponseEntity<EnderecoDTO> registrar(@RequestBody EnderecoDTO enderecoDTO) {
        ResponseEntity responseEntity = null;

        if (enderecoDTO.getRua() != null) {
            EnderecoDTO enderecoDTO1 = enderecoService.create(enderecoDTO);
            responseEntity = new ResponseEntity<>(enderecoDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Rua não preenchida.", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/buscar")
    public List<EnderecoDTO> buscarTodos() {
        return enderecoService.getAll();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        enderecoService.delete(id);
    }

    @PutMapping("/{id}")
    public EnderecoDTO modificar(@RequestBody EnderecoDTO enderecoDTO, @PathVariable int id) {
        return enderecoService.update(enderecoDTO, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarID(@PathVariable int id) {
        ResponseEntity responseEntity = null;

        EnderecoDTO enderecoDTO = enderecoService.getById(id);

        if (enderecoDTO != null) {
            responseEntity = new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("ID não encontrado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
=======
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
>>>>>>> 42559ef2c0df1b55cd9d77d71677354365cda722
