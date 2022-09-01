package com.digitalhouse.clinicaodontologicag6.service.impl;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import com.digitalhouse.clinicaodontologicag6.entity.dto.DentistaDTO;
import com.digitalhouse.clinicaodontologicag6.repository.DentistaRepository;
import com.digitalhouse.clinicaodontologicag6.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO registrar(DentistaDTO dentistaDTO) {
        DentistaEntity dentistaEntitie = new DentistaEntity(dentistaDTO);
        dentistaRepository.create(dentistaEntitie);
        return dentistaDTO;
    }
    @Override
    public DentistaDTO registrar(DentistaDTO dentistaDTO) {
        return null;
    }

    @Override
    public List<DentistaDTO> buscarTodos() {
        return null;
    }

    @Override
    public String excluir(Integer id) {
        return null;
    }

    @Override
    public DentistaDTO modificar(DentistaDTO dentistaDTO, int id) {
        return null;
    }

    @Override
    public DentistaDTO buscarID(int id) {
        return null;
    }
}
