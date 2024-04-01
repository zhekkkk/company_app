package org.example.repository;

import org.example.entity.Department;

import java.util.UUID;

public interface DepartmentRepository extends Repository<Department, UUID> {

    void addEmployee(UUID uuid);

    void removeEmployee(UUID uuid);

}
