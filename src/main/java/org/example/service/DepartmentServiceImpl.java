package org.example.service;

import org.example.entity.Department;
import org.example.repository.DepartmentRepository;
import org.example.repository.DepartmentRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class DepartmentServiceImpl implements DepartmentService {

    private static DepartmentServiceImpl instance;

    private DepartmentRepository departmentRepository;

    private DepartmentServiceImpl()
    {
        departmentRepository = DepartmentRepositoryImpl.getInstance();
    }

    public static DepartmentServiceImpl getInstance() {
        if (instance == null)
            instance = new DepartmentServiceImpl();
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
