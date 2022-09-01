package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IPacienteRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = mapperDTOToEntity(pacienteDTO);
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        pacienteDTO = mapperEntityToDTO(pacienteEntity);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO getById(int id) {
        PacienteEntity paciente = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = mapperEntityToDTO(paciente);
        return pacienteDTO;
    }

    @Override
    public List<PacienteDTO> getAll() {
        List<PacienteEntity> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(this::mapperEntityToDTO).toList();
    }

    @Override
    public String delete(int id) {
        pacienteRepository.deleteById(id);
        return "<h1>Paciente de id " + id + " deletado !</h1>";
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
        return null;
    }

    private PacienteEntity mapperDTOToEntity(PacienteDTO pacienteDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteEntity paciente = objectMapper.convertValue(
                pacienteDTO,
                PacienteEntity.class
        );
        return paciente;
    }

    private PacienteDTO mapperEntityToDTO(PacienteEntity pacienteEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteDTO paciente = objectMapper.convertValue(
                pacienteEntity,
                PacienteDTO.class
        );
        return paciente;
    }

    public PacienteDTO getByNome(String nome) {
        PacienteEntity paciente = pacienteRepository.getByNome(nome);
        PacienteDTO pacienteDTO = mapperEntityToDTO(paciente);
        return pacienteDTO;
    }
}
