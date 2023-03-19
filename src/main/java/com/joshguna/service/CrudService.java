package com.joshguna.service;

import java.util.List;

public interface CrudService<T, ID> {

    T save(T object);

    T findByID(ID id);

    List<T> findAll();

    void deleteByID(ID id);
}
