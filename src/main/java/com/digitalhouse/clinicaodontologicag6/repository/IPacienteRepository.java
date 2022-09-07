package com.digitalhouse.clinicaodontologicag6.repository;

import com.digitalhouse.clinicaodontologicag6.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {
}
