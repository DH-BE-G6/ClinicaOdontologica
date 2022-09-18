package com.digitalhouse.clinicaodontologicag6.service.impl;

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

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = mapperDTOToEntity(pacienteDTO);
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        pacienteDTO = mapperEntityToDTO(pacienteEntity);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO getById(Long id) {
        PacienteEntity paciente = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = mapperEntityToDTO(paciente);
        return pacienteDTO;
    }

    public List<PacienteDTO> getByNome(String nome) {
        List<PacienteEntity> pacientes = pacienteRepository.getByNome(nome);
        return pacientes.stream().map(this::mapperEntityToDTO).toList();
    }

    public PacienteDTO getByRg(String rg) {
        PacienteEntity paciente = pacienteRepository.getByRg(rg);
        PacienteDTO pacienteDTO = mapperEntityToDTO(paciente);
        return pacienteDTO;
    }

    public List<PacienteDTO> getByCidade(String cidade) {
        List<PacienteEntity> pacientes = pacienteRepository.getByCidade(cidade);
        return pacientes.stream().map(this::mapperEntityToDTO).toList();
    }

    @Override
    public List<PacienteDTO> getAll() {
        List<PacienteEntity> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(this::mapperEntityToDTO).toList();
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO, Long id) {
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
        pacienteEntity.setNome(pacienteDTO.getNome());
        pacienteEntity.setSobrenome(pacienteDTO.getSobrenome());
        pacienteEntity.setRg(pacienteDTO.getRg());
        pacienteEntity.setLogradouro(pacienteDTO.getLogradouro());
        pacienteEntity.setNumero(pacienteDTO.getNumero());
        pacienteEntity.setComplemento(pacienteDTO.getComplemento());
        pacienteEntity.setCidade(pacienteDTO.getCidade());
        pacienteEntity.setEstado(pacienteDTO.getEstado());
        pacienteEntity.setCep(pacienteDTO.getCep());
        pacienteRepository.save(pacienteEntity);
        return new PacienteDTO(pacienteEntity);
    }

    @Override
    public String delete(Long id) {
        pacienteRepository.deleteById(id);
        return "Paciente excluído! (ID: " + id + ")";
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

    public PacienteEntity findById(Long paciente) {
        return pacienteRepository.findById(paciente).orElseThrow(() -> {
            throw new RuntimeException("Paciente não encontrado!");
        });
    }

}
