package com.digitalhouse.clinicaodontologicag6.service;

import java.util.List;

public interface IClinicaService<T> {
    T registrar(T t);

    List<T> buscarTodos();

    String excluir(Integer id);

    T modificar(T t, int id);

    T buscarID(int id);
}
