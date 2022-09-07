package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoDTO;
import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IPacienteRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {

    @Autowired
    private IPacienteRepository pacienteRepository;

   @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = mapperDTOToEntity(pacienteDTO);
        EnderecoDTO enderecoDTO;
        int idEndereco = pacienteEntity.getEndereco().getId();
        if (enderecoService.ifCategoryExists(idEndereco)) {
            enderecoDTO = enderecoService.getById(idEndereco);
            EnderecoEntity endereco = new EnderecoEntity(enderecoDTO);
            pacienteEntity.setCategory(endereco);
            pacienteEntity = pacienteRepository.save(pacienteEntity);
        }
        pacienteDTO = mapperEntityToDTO(pacienteEntity);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO getById(int id) {
        PacienteEntity paciente = pacienteRepository.findById(id).get();
        return new PacienteDTO(paciente);
    }

    @Override
    public List<PacienteDTO> getAll() {
        PacienteEntity paciente = (PacienteEntity) pacienteRepository.findAll();
        return (List<PacienteDTO>) new PacienteDTO(paciente);
    }

    @Override
    public void delete(int id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
        return null;
    }

    private PacienteEntity mapperDTOToEntity(PacienteDTO pacienteDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteEntity paciente = objectMapper.convertValue(pacienteDTO, PacienteEntity.class);
        return paciente;
    }

    private PacienteDTO mapperEntityToDTO(PacienteEntity pacienteEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteDTO paciente = objectMapper.convertValue(pacienteEntity, PacienteDTO.class);
        return paciente;
    }
}