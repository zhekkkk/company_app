package org.example.service;

import org.example.entity.Department;

import java.util.UUID;

public interface DepartmentService extends Service<Department, UUID> {

    void addEmployee(UUID uuid);

    void removeEmployee(UUID uuid);

    double getTotalSalary(UUID uuid);

}
