package com.digitalhouse.clinicaodontologicag6.dao;

public interface IDao<T> {
    T create(T t);
    void delete(int id);
    T get(int id);
    T update(int id);

}
