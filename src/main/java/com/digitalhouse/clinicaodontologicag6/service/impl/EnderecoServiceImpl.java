package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.EnderecoEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.EnderecoDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IEnderecoRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO> {

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        EnderecoEntity enderecoEntity = mapperDTOToEntity(enderecoDTO);
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id).get();
        EnderecoDTO enderecoDTO = mapperEntityToDTO(enderecoEntity);
        return enderecoDTO;
    }

    @Override
    public List<EnderecoDTO> getAll() {
        List<EnderecoEntity> enderecoEntities = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (EnderecoEntity endereco : enderecoEntities) {//
            EnderecoDTO enderecoDTO = mapperEntityToDTO(endereco);//
            enderecoDTOS.add(enderecoDTO);
        }
        return enderecoDTOS;
    }

    @Override
    public void delete(int id) {
        enderecoRepository.deleteById(id);
        System.out.println("Endereço Deletado");
    }

    @Override
    public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
        EnderecoEntity enderecoEntity = mapperDTOToEntity(enderecoDTO);
        if (enderecoRepository.findById(id) != null) {
            enderecoEntity.setId(id);
            enderecoRepository.save(enderecoEntity);
            return enderecoDTO;
        } else {
            enderecoRepository.save(enderecoEntity);
            return enderecoDTO;
        }
    }

    private EnderecoEntity mapperDTOToEntity(EnderecoDTO enderecoDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoEntity endereco = objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
        return endereco;
    }
    private EnderecoDTO mapperEntityToDTO(EnderecoEntity enderecoEntity){
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoDTO endereco = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        return endereco;
    }
}