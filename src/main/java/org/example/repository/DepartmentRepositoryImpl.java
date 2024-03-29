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
        return null;
    }

    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public void add(Department obj) {

    }

    @Override
    public void removeById(UUID uuid) {

    }

    @Override
    public void update(Department obj) {

    }
}
