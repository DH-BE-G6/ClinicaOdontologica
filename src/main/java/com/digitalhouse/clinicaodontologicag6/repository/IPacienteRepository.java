package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    //HQL
    @Query("FROM PacienteEntity p where p.nome = :nome")
    PacienteEntity getByNome(String nome);

}
