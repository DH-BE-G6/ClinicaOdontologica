package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {

    //HQL
    @Query("FROM ConsultaEntity c where c.dentista = :dentista")
    List<ConsultaEntity> getByDentista(int dentista);

    @Query("FROM ConsultaEntity c where c.paciente = :paciente")
    List<ConsultaEntity> getByPaciente(int paciente);

    @Query("FROM ConsultaEntity c where c.dataConsulta = :data")
    List<ConsultaEntity> getByData(String data);
}
