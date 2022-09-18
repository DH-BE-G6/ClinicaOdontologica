package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IDentistaRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<DentistaDTO> getByNome(String nome) {
        List<DentistaEntity> dentistas = dentistaRepository.getByNome(nome);
        return dentistas.stream().map(this::mapperEntityToDTO).toList();
    }

    public DentistaDTO getByMatricula(String matricula) {
        DentistaEntity dentista = dentistaRepository.getByMatricula(matricula);
        DentistaDTO dentistaDTO = mapperEntityToDTO(dentista);
        return dentistaDTO;
    }

    @Override
    public List<DentistaDTO> getAll() {
        List<DentistaEntity> dentistas = dentistaRepository.findAll();
        return dentistas.stream().map(this::mapperEntityToDTO).toList();
    }

    @Override
    public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
        DentistaEntity dentistaEntity = dentistaRepository.findById(id).get();
        dentistaEntity.setNome(dentistaDTO.getNome());
        dentistaEntity.setSobrenome(dentistaDTO.getSobrenome());
        dentistaEntity.setMatricula(dentistaDTO.getMatricula());
        dentistaRepository.save(dentistaEntity);
        return new DentistaDTO(dentistaEntity);
    }

    @Override
    public String delete(int id) {
        dentistaRepository.deleteById(id);
        return "Dentista excluído! (ID: " + id + ")";
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