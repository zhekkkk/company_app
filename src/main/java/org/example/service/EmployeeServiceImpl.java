package org.example.service;

import org.example.dbservice.EmployeeDBService;
import org.example.dbservice.EmployeeDBServiceImpl;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.EmployeeRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService{

    private static EmployeeServiceImpl instance;

    private EmployeeRepository employeeRepository;

    private EmployeeDBService employeeDBService;

    private EmployeeServiceImpl() {
        employeeRepository = EmployeeRepositoryImpl.getInstance();
        employeeDBService = EmployeeDBServiceImpl.getInstance();
    }

    public static EmployeeServiceImpl getInstance() {
        if (instance == null)
            instance = new EmployeeServiceImpl();
        return instance;
    }

    @Override
    public List<Employee> getByDepartmentId(UUID departmentId) {
        return employeeDBService.getByDepartmentId(departmentId);
    }

    @Override
    public Employee getById(UUID uuid) {
        return employeeDBService.getById(uuid);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDBService.getAll();
    }

    @Override
    public void add(Employee obj) {
        employeeDBService.add(obj);
        DepartmentServiceImpl.getInstance().addEmployee(obj.getDepartmentId());
    }

    @Override
    public void removeById(UUID uuid) {
        DepartmentServiceImpl.getInstance().removeEmployee(employeeDBService.getById(uuid).getDepartmentId());
        employeeDBService.removeById(uuid);
    }

    @Override
    public void update(Employee obj) {
        employeeDBService.update(obj);
    }



/*
    @Override
    public List<Employee> getByDepartmentId(UUID departmentId) {
        return employeeRepository.getByDepartmentId(departmentId);
    }

    @Override
    public Employee getById(UUID uuid) {
        return employeeRepository.getById(uuid);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public void add(Employee obj) {
        employeeRepository.add(obj);
        DepartmentServiceImpl.getInstance().addEmployee(obj.getDepartmentId());
    }

    @Override
    public void removeById(UUID uuid) {
        DepartmentServiceImpl.getInstance().removeEmployee(employeeRepository.getById(uuid).getDepartmentId());
        employeeRepository.removeById(uuid);
    }

    @Override
    public void update(Employee obj) {
        List<Employee> objects = employeeRepository.getAll();
        for (Employee emp : objects)
        {
            if (obj.getId() == emp.getId())
            {
                if (emp.getDepartmentId() != obj.getDepartmentId())
                {
                    DepartmentServiceImpl.getInstance().removeEmployee(emp.getDepartmentId());
                    DepartmentServiceImpl.getInstance().addEmployee(obj.getDepartmentId());
                }
            }
        }
        employeeRepository.update(obj);
    }*/
}
