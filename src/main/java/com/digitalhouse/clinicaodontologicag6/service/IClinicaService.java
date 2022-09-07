package com.digitalhouse.clinicaodontologicag6.service;

import java.util.List;

public interface IClinicaService<T> {
    T create(T t);
    T getById(int id);
    List<T> getAll();
    String delete(int id);
    T update(T t, int id);
}