package org.example.dbservice;

import java.util.List;

public interface DBService<T, Id> {

    void add(T obj);

    T getById(Id id);

    void removeById(Id id);

    void update(T obj);

    List<T> getAll();

}
