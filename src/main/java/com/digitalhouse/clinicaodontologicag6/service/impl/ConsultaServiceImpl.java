package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.ConsultaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.ConsultaDTO;
import com.digitalhouse.clinicaodontologicag6.repository.IConsultaRepository;
import com.digitalhouse.clinicaodontologicag6.repository.IDentistaRepository;
import com.digitalhouse.clinicaodontologicag6.repository.IPacienteRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {

    @Autowired
    private IConsultaRepository consultaRepository;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        ConsultaEntity consultaEntity = mapperDTOToEntity(consultaDTO);
        consultaEntity = consultaRepository.save(consultaEntity);
        consultaDTO = mapperEntityToDTO(consultaEntity);
        return consultaDTO;
    }

    @Override
    public ConsultaDTO getById(int id) {
        ConsultaEntity consulta = consultaRepository.findById(id).get();
        ConsultaDTO consultaDTO = mapperEntityToDTO(consulta);
        return consultaDTO;
    }

    public List<ConsultaDTO> getByDentista(int dentista) {
        List<ConsultaEntity> consultas = consultaRepository.getByDentista(dentista);
        return consultas.stream().map(this::mapperEntityToDTO).toList();
    }

    public List<ConsultaDTO> getByPaciente(int paciente) {
        List<ConsultaEntity> consultas = consultaRepository.getByPaciente(paciente);
        return consultas.stream().map(this::mapperEntityToDTO).toList();
    }

    public List<ConsultaDTO> getByData(String data) {
        List<ConsultaEntity> consultas = consultaRepository.getByData(data);
        return consultas.stream().map(this::mapperEntityToDTO).toList();
    }

    @Override
    public List<ConsultaDTO> getAll() {
        List<ConsultaEntity> consultas = consultaRepository.findAll();
        return consultas.stream().map(this::mapperEntityToDTO).toList();
    }

    @Override
    public String delete(int id) {
        consultaRepository.deleteById(id);
        return "Consulta excluída! (ID: " + id + ")";
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id) {
        ConsultaEntity consultaEntity = consultaRepository.findById(id).get();
        consultaEntity.setPaciente(consultaDTO.getPaciente());
        consultaEntity.setDentista(consultaDTO.getDentista());
        consultaEntity.setDataConsulta(consultaDTO.getDataConsulta());
        consultaEntity.setConsultaFinished(consultaDTO.isConsultaFinished());
        consultaRepository.save(consultaEntity);
        return consultaDTO;
    }

    private ConsultaEntity mapperDTOToEntity(ConsultaDTO consultaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaEntity consulta = objectMapper.convertValue(
                consultaDTO,
                ConsultaEntity.class
        );
        return consulta;
    }

    private ConsultaDTO mapperEntityToDTO(ConsultaEntity consultaEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaDTO consulta = objectMapper.convertValue(
                consultaEntity,
                ConsultaDTO.class
        );
        return consulta;
    }

}
