package org.example.dbservice;

import org.example.entity.Department;

import java.util.UUID;

public interface DepartmentDBService extends DBService<Department, UUID> {

    void addEmployee(UUID uuid);

    void removeEmployee(UUID uuid);

    double getTotalSalary(UUID uuid);

}
