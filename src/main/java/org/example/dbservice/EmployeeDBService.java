package org.example.dbservice;

import org.example.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeDBService extends DBService<Employee, UUID> {

    List<Employee> getByDepartmentId(UUID uuid);

}
