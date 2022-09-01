package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {
    @Query("FROM DentistaEntity p where p.nome = :nome")
    DentistaEntity getByNome(String nome);
}
