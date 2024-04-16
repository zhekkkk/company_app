package org.example.entity;

import java.util.UUID;

public class Department implements Identifiable<UUID> {

    private UUID id;

    private String name;
    private int numberOfEmployees;

    public Department(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.numberOfEmployees = 0;
    }

    public Department(UUID id, String name, int numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }
}
