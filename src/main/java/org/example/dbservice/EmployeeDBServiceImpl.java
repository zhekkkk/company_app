package org.example.dbservice;

import org.example.entity.Department;
import org.example.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeDBServiceImpl implements EmployeeDBService{

    private DBConnectionService dbConnectionService;
    private Statement statement;
    private ResultSet resultSet;

    private static EmployeeDBServiceImpl instance;

    private EmployeeDBServiceImpl() {
        dbConnectionService = DBConnectionService.getInstance();
    }

    public static EmployeeDBServiceImpl getInstance() {
        if (instance == null)
            instance = new EmployeeDBServiceImpl();
        return instance;
    }

    @Override
    public List<Employee> getByDepartmentId(UUID uuid) {
        String sql = "SELECT * FROM employees WHERE department_id = '" + uuid + "';";
        List<Employee> employees = new ArrayList<>();
        try {
            createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                UUID id = (UUID)resultSet.getObject("id");
                UUID departmentId =(UUID)resultSet.getObject("department_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                employees.add(new Employee(id, departmentId, name, surname, patronymic, age, salary));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    @Override
    public void add(Employee obj) {
        String sql = "INSERT INTO employees (id, department_id, name, surname, patronymic, age, salary) VALUES (" +
                "'" + obj.getId() + "', '" + obj.getDepartmentId() + "', '" + obj.getName() + "', '" + obj.getSurname() +
                "', '" + obj.getPatronymic() + "', " + obj.getAge() + ", " + obj.getSalary() + ");";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Employee getById(UUID uuid) {
        String sql = "SELECT * FROM employees WHERE id = '" + uuid + "';";
        Employee employee = null;
        try {
            createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                UUID id = (UUID)resultSet.getObject("id");
                UUID departmentId =(UUID)resultSet.getObject("department_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                employee = new Employee(id, departmentId, name, surname, patronymic, age, salary);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    @Override
    public void removeById(UUID uuid) {
        String sql = "DELETE FROM employees WHERE id = '" + uuid + "';";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Employee obj) {
        String sql = "UPDATE employees SET department_id = '" + obj.getDepartmentId() +
                "', name = '" + obj.getName() +
                "', surname = '" + obj.getSurname() +
                "', patronymic = '" + obj.getPatronymic() +
                "', age = " + obj.getAge() +
                ", salary = " + obj.getSalary() +
                " WHERE id = '" + obj.getId() + "';";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employees;";
        List<Employee> employees = new ArrayList<>();
        try {
            createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                UUID id = (UUID)resultSet.getObject("id");
                UUID departmentId =(UUID)resultSet.getObject("department_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String patronymic = resultSet.getString("patronymic");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                employees.add(new Employee(id, departmentId, name, surname, patronymic, age, salary));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    private void createStatement() {
        statement = dbConnectionService.createStatement();
    }
}
