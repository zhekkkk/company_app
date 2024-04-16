package org.example.service;

import org.example.dbservice.DepartmentDBService;
import org.example.dbservice.DepartmentDBServiceImpl;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.repository.DepartmentRepository;
import org.example.repository.DepartmentRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class DepartmentServiceImpl implements DepartmentService {

    private static DepartmentServiceImpl instance;

    private DepartmentRepository departmentRepository;

    private DepartmentDBService departmentDBService;

    private DepartmentServiceImpl()
    {
        departmentRepository = DepartmentRepositoryImpl.getInstance();
        departmentDBService = DepartmentDBServiceImpl.getInstance();
    }

    public static DepartmentServiceImpl getInstance() {
        if (instance == null)
            instance = new DepartmentServiceImpl();
        return instance;
    }

    @Override
    public void addEmployee(UUID uuid) {
        departmentDBService.addEmployee(uuid);
    }

    @Override
    public void removeEmployee(UUID uuid) {
        departmentDBService.removeEmployee(uuid);
    }

    @Override
    public double getTotalSalary(UUID uuid) {
        return 0;
    }

    @Override
    public Department getById(UUID uuid) {
        return departmentDBService.getById(uuid);
    }

    @Override
    public List<Department> getAll() {
        return departmentDBService.getAll();
    }

    @Override
    public void add(Department obj) {
        departmentDBService.add(obj);
    }

    @Override
    public void removeById(UUID uuid) {
        departmentDBService.removeById(uuid);
    }

    @Override
    public void update(Department obj) {
        departmentDBService.update(obj);
    }


/*
    @Override
    public Department getById(UUID uuid) {
        return departmentRepository.getById(uuid);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.getAll();
    }

    @Override
    public void add(Department obj) {
        departmentRepository.add(obj);
    }

    @Override
    public void removeById(UUID uuid) {
        List<Employee> employees = EmployeeServiceImpl.getInstance().getByDepartmentId(uuid);
        for (Employee emp : employees)
        {
            EmployeeServiceImpl.getInstance().removeById(emp.getId());
        }
        departmentRepository.removeById(uuid);
    }

    @Override
    public void update(Department obj) {
        departmentRepository.update(obj);
    }

    @Override
    public void addEmployee(UUID uuid) {
        departmentRepository.addEmployee(uuid);
    }

    @Override
    public void removeEmployee(UUID uuid) {
        departmentRepository.removeEmployee(uuid);
    }

    @Override
    public double getTotalSalary(UUID uuid) {
        List<Employee> employees = EmployeeServiceImpl.getInstance().getByDepartmentId(uuid);
        double totalSalary = 0;
        for (Employee emp : employees)
        {
            totalSalary += emp.getSalary();
        }
        return totalSalary;
    }*/

}
