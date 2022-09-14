package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.ConsultaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.ConsultaDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IConsultaRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {

    @Autowired
    IConsultaRepository iConsultaRepository;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) {

        ConsultaEntity consultaEntity = mapperDTOToEntity(consultaDTO);
        consultaEntity = iConsultaRepository.save(consultaEntity);
        consultaDTO = new ConsultaDTO(consultaEntity);
        return consultaDTO;
    }

    @Override
    public List<ConsultaDTO> getAll() {
        List<ConsultaEntity> consultaEntities = iConsultaRepository.findAll();
        List<ConsultaDTO> consultaDTOS = new ArrayList<>();

        for (ConsultaEntity consultaEntity : consultaEntities){
            ConsultaDTO consultaDTO = mapperEntityToDTO(consultaEntity);
            consultaDTOS.add(consultaDTO);
        }
        return consultaDTOS;
    }

    @Override
    public String delete(int id) {
        iConsultaRepository.deleteById(id);
        return "Removido";
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id) {
        ConsultaEntity consultaEntity = mapperDTOToEntity(consultaDTO);

        if(iConsultaRepository.findById(id) != null){
            consultaEntity.setId(id);
            return consultaDTO;
        } else {
            iConsultaRepository.save(consultaEntity);
            return consultaDTO;
        }
    }

    @Override
    public ConsultaDTO getById(int id) {
        ConsultaEntity consultaEntity = iConsultaRepository.findById(id).get();
        ConsultaDTO consultaDTO = mapperEntityToDTO(consultaEntity);
        return consultaDTO;
    }

    private ConsultaEntity mapperDTOToEntity(ConsultaDTO consultaDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaEntity consultaEntity = objectMapper.convertValue(consultaDTO, ConsultaEntity.class);
        return consultaEntity;
    }

    private ConsultaDTO mapperEntityToDTO(ConsultaEntity consultaEntity){
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaDTO consultaDTO = objectMapper.convertValue(consultaEntity, ConsultaDTO.class);
        return consultaDTO;
    }


}