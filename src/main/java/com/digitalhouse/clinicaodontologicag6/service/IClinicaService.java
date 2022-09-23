package com.digitalhouse.clinicaodontologicag6.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IClinicaService<T> {

    T create(T t);
    T getById(Long id);
    List<T> getAll();
    String delete(Long id);
    T update(T t, Long id);
}
