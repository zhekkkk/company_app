package org.example.entity;

public interface Identifiable<T> {

    T getId();

    void setId(T id);

}
