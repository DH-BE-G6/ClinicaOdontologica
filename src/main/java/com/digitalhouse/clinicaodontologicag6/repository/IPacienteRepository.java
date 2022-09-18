package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    //HQL
    @Query("FROM PacienteEntity p where p.nome = :nome")
    List<PacienteEntity> getByNome(String nome);

    @Query("FROM PacienteEntity p where p.rg = :rg")
    PacienteEntity getByRg(String rg);

    @Query("FROM PacienteEntity p where p.cidade = :cidade")
    List<PacienteEntity> getByCidade(String cidade);

}
