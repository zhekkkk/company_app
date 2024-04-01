package org.example.repository;

import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> objects;

    private static EmployeeRepositoryImpl instance;

    private EmployeeRepositoryImpl()
    {
        objects = new ArrayList<>();
    }

    public static EmployeeRepositoryImpl getInstance()
    {
        if(instance == null)
            instance = new EmployeeRepositoryImpl();
        return instance;
    }

    @Override
    public Employee getById(UUID uuid) {
        for (Employee obj : objects)
        {
            if (obj.getId() == uuid) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return List.copyOf(objects);
    }

    @Override
    public void add(Employee obj) {
        objects.add(obj);
        //DepartmentServiceImpl.getInstance().getById(obj.getDepartmentId()).setNumberOfEmployees();
    }

    @Override
    public void removeById(UUID uuid) {
        objects.removeIf(obj -> obj.getId() == uuid);
    }

    @Override
    public void update(Employee obj) {

    }

    @Override
    public List<Employee> getByDepartmentId(UUID departmentId) {
        return null;
    }
}
