package org.example.repository;

import org.example.entity.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private List<Department> objects;

    private static DepartmentRepositoryImpl instance;

    private DepartmentRepositoryImpl()
    {
        objects = new ArrayList<>();
    }

    public static DepartmentRepositoryImpl getInstance() {
        if (instance == null)
            instance = new DepartmentRepositoryImpl();
        return instance;
    }

    @Override
    public Department getById(UUID uuid) {
        for (Department obj : objects) {
            if (obj.getId() == uuid) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<Department> getAll() {
        return objects;
    }

    @Override
    public void add(Department obj) {
        objects.add(obj);
    }

    @Override
    public void removeById(UUID uuid) {
        objects.removeIf(obj -> obj.getId() == uuid);
    }

    @Override
    public void update(Department obj) {
        for (Department dep : objects)
        {
            if (obj.getId() == dep.getId())
            {
                dep.setName(obj.getName());
            }
        }
    }

    @Override
    public void addEmployee(UUID uuid) {
        for(Department obj : objects)
        {
            if (obj.getId() == uuid)
            {
                int currNumOfEmployees = obj.getNumberOfEmployees();
                obj.setNumberOfEmployees(currNumOfEmployees + 1);
            }
        }
    }

    @Override
    public void removeEmployee(UUID uuid) {
        for(Department obj : objects)
        {
            if (obj.getId() == uuid)
            {
                int currNumOfEmployees = obj.getNumberOfEmployees();
                obj.setNumberOfEmployees(currNumOfEmployees - 1);
            }
        }
    }
}
