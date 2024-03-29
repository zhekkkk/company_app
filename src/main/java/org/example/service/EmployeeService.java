package org.example.service;

import org.example.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService extends Service<Employee, UUID> {

    List<Employee> getByDepartmentId(UUID departmentId);

}
