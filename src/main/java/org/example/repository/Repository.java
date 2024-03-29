package org.example.repository;

import java.util.List;

public interface Repository<T, Id> {

    T getById(Id id);

    List<T> getAll();

    void add(T obj);

    void removeById(Id id);

    void update(T obj);

}
