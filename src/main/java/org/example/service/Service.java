package org.example.service;

import java.util.List;

public interface Service<T, Id> {

    T getById(Id id);

    List<T> getAll();

    void add(T obj);

    void removeById(Id id);

    void update(T obj);

}
