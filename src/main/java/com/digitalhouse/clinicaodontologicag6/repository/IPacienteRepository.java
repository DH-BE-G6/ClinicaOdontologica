package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    //HQL
    @Query("FROM PacienteEntity p where p.nome = :nome")
    List<PacienteEntity> getByNome(String nome);

}
