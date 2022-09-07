package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.entity.dto.PacienteDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IDentistaRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    private IDentistaRepository dentistaRepository;
    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        DentistaEntity dentistaEntity = mapperDTOToEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.save(dentistaEntity);
        dentistaDTO = new DentistaDTO(dentistaEntity);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        DentistaEntity dentista = dentistaRepository.findById(id).get();
        return new DentistaDTO(dentista);
    }

    @Override
    public List<DentistaDTO> getAll() {
        DentistaEntity dentista = (DentistaEntity) dentistaRepository.findAll();
        return (List<DentistaDTO>) new DentistaDTO(dentista);
    }

    @Override
    public void delete(int id) {
        dentistaRepository.deleteById(id);
    }

    @Override
    public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
        return null;
    }

    private DentistaEntity mapperDTOToEntity(DentistaDTO dentistaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaEntity dentista = objectMapper.convertValue(dentistaDTO, DentistaEntity.class);
        return dentista;
    }

    private DentistaDTO mapperEntityToDTO(DentistaEntity dentistaEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaDTO dentista = objectMapper.convertValue(dentistaEntity, DentistaDTO.class);
        return dentista;
    }
}