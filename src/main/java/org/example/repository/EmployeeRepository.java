package org.example.repository;

import org.example.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends Repository<Employee, UUID> {

    List<Employee> getByDepartmentId(UUID departmentId);

}
