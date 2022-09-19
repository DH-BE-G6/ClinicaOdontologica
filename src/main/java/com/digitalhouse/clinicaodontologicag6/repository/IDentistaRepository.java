package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDentistaRepository extends JpaRepository<DentistaEntity, Long> {

    //HQL
    @Query("FROM DentistaEntity d where d.nome = :nome")
    List<DentistaEntity> getByNome(String nome);

    @Query("FROM DentistaEntity d where d.matricula = :matricula")
    DentistaEntity getByMatricula(String matricula);

}
