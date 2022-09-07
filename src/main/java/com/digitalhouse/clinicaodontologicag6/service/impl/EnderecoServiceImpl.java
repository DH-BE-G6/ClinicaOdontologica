package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoDTO;
import com.digitalhouse.clinicaodontologicag6.entity.EnderecoEntity;
import com.digitalhouse.clinicaodontologicag6.repository.IEnderecoRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO> {

    @Autowired
    private IEnderecoRepository enderecoRepository;

//    @Autowired
//    private EnderecoServiceImpl enderecoService;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(enderecoDTO);
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        enderecoDTO = new EnderecoDTO(enderecoEntity);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        EnderecoEntity endereco = enderecoRepository.findById(id).get();
        return new EnderecoDTO(endereco);
    }

    @Override
    public List<EnderecoDTO> getAll() {
        EnderecoEntity endereco = (EnderecoEntity) enderecoRepository.findAll();
        return (List<EnderecoDTO>) new EnderecoDTO(endereco);
    }

    @Override
    public void delete(int id) {
        enderecoRepository.deleteById(id);
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
        return null;
    }

    private EnderecoEntity mapperDTOToEntity(EnderecoDTO enderecoDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoEntity endereco = objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
        return endereco;
    }

    private EnderecoDTO mapperEntityToDTO(EnderecoEntity enderecoEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoDTO endereco = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        return endereco;
    }
}