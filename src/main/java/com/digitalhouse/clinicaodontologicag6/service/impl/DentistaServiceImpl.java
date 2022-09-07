package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IDentistaRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    private IDentistaRepository dentistaRepository;

    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        DentistaEntity dentistaEntity = mapperDTOToEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.save(dentistaEntity);
        dentistaDTO = mapperEntityToDTO(dentistaEntity);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        DentistaEntity dentista = dentistaRepository.findById(id).get();
        DentistaDTO dentistaDTO = mapperEntityToDTO(dentista);
        return dentistaDTO;
    }

    @Override
    public List<DentistaDTO> getAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return "";
    }

    @Override
    public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
        return null;
    }

    private DentistaEntity mapperDTOToEntity(DentistaDTO dentistaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaEntity dentista = objectMapper.convertValue(
                dentistaDTO,
                DentistaEntity.class
        );
        return dentista;
    }

    private DentistaDTO mapperEntityToDTO(DentistaEntity dentistaEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaDTO dentista = objectMapper.convertValue(
                dentistaEntity,
                DentistaDTO.class
        );
        return dentista;
    }
}
